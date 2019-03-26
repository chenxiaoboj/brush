package com.tourist.module.brushticket.service.component;

import com.alibaba.fastjson.JSONObject;
import com.tourist.module.brushticket.dao.ExceptionInfoDao;
import com.tourist.module.brushticket.entity.BrushExceptionInfo;
import com.tourist.module.brushticket.entity.BrushTicketInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator 2019-03-05 0:31
 */
@Component
public class FirstTest {

    private static final Logger logger = LoggerFactory.getLogger(FirstTest.class);
    private static final String V_URL = "https://937707mltg.sjdzp.cn/Miniwx/Index/getOrdersVerify.json";
    private static final String CREATE_ORDER_URL = "https://937707mltg.sjdzp.cn/Miniwx/Index/orders.json";
    @Resource
    private ExceptionInfoDao exceptionInfoDao;

    public String firstTest(BrushTicketInfo brushTicketDto, NameValuePair[] parameter, String goodId) {
        logger.info(brushTicketDto.getHostName());
        BrushExceptionInfo exceptionInfo = new BrushExceptionInfo();
        exceptionInfo.setParameter(Arrays.toString(parameter));
        exceptionInfo.setCreateTime(new Date());
        exceptionInfo.setDelFlag("test");
        try {
            //设置代理IP
            HttpHost proxy = new HttpHost(brushTicketDto.getHostName(), brushTicketDto.getPort(), "http");
            CloseableHttpClient httpclient = HttpClients
                    .custom()
                    .setDefaultCookieStore(new BasicCookieStore())
                    .setProxy(proxy)
                    .setConnectionTimeToLive(1000 * 3, TimeUnit.MILLISECONDS)
                    .build();
            CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.post()
                    .setUri(new URI(V_URL))
                    .setHeader("Accept", "application/json, text/javascript, */*; q=0.01")
                    .setHeader("Accept-Encoding", "gzip, deflate, br")
                    .setHeader("Accept-Language", "zh-CN,zh;q=0.9")
                    .setHeader("Connection", "keep-alive")
                    .setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .setHeader("Host", "937707mltg.sjdzp.cn")
                    .setHeader("Origin", "https://937707mltg.sjdzp.cn")
                    .setHeader("Referer", "https://937707mltg.sjdzp.cn/Miniwx/Index/buy.html?goods_id=" + goodId + "&form=1&cc=1")
                    .setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                    .setHeader("X-Requested-With", "XMLHttpRequest")
                    .addParameter("verify_type", "1")
                    .build());
            String result = EntityUtils.toString(http1.getEntity());
            JSONObject verifyJson = JSONObject.parseObject(result);
            if (StringUtils.equalsIgnoreCase("false", verifyJson.getString("success"))) {
                //判断获取验证码结果
                String errorMessage = verifyJson.getString("message");
                logger.info(errorMessage);
                return null;
            }
            String verify = JSONObject.parseObject(result).getString("verify");
            String cookie = http1.getHeaders("Set-Cookie")[1].getValue() + "; " + http1.getHeaders("Set-Cookie")[0].getValue();
            logger.info("test ------验证码-------：" + verify);
            logger.info("test ------cookie-------：" + cookie);
            logger.info("test 线程名称：" + Thread.currentThread().getName() + "-----" + brushTicketDto.getHostName());
            exceptionInfo.setCookie(cookie);
            http1.close();
            Thread.sleep(5000);
            CloseableHttpResponse http2 = httpclient.execute(RequestBuilder.post()
                    .setUri(new URI(CREATE_ORDER_URL))
                    .setHeader("Host", "937707mltg.sjdzp.cn")
                    .setHeader("Connection", "keep-alive")
                    .setHeader("Accept", "application/json, text/javascript, */*; q=0.01")
                    .setHeader("Origin", "https://937707mltg.sjdzp.cn")
                    .setHeader("X-Requested-With", "XMLHttpRequest")
                    .setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                    .setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .setHeader("Referer", "https://937707mltg.sjdzp.cn/Miniwx/Index/buy.html?goods_id=" + goodId + "&form=1&cc=1")
                    .setHeader("Accept-Encoding", "gzip, deflate, br")
                    .setHeader("Accept-Language", "zh-CN,zh;q=0.9")
                    .setHeader("Cookie", cookie)
                    .addParameter("orders_verify", verify)
                    .addParameters(parameter)
                    .setConfig(RequestConfig.custom().setRedirectsEnabled(false).setConnectTimeout(5000).build())
                    .build());
            String orderResult = EntityUtils.toString(http2.getEntity());
            JSONObject orderJson = JSONObject.parseObject(orderResult);
            if (StringUtils.equalsIgnoreCase("false", orderJson.getString("success"))) {
                String errorMessage = orderJson.getString("message");
                logger.info(errorMessage);
                return null;
            }
            String auth_orders_id = JSONObject.parseObject(orderResult).getJSONObject("data").getString("auth_orders_id");
            logger.info("------------------auth_orders_id-------------" + auth_orders_id);
            exceptionInfo.setAuthOrdersId(auth_orders_id);
            http2.close();
            httpclient.close();
        } catch (IOException e) {
            logger.info("test 其他异常信息" + e.getMessage());
            exceptionInfo.setMessage(e.getMessage());
            exceptionInfo.setCount(4);
            exceptionInfoDao.save(exceptionInfo);
            return null;
        } catch (URISyntaxException e) {
            logger.info("test 其他异常信息" + e.getMessage());
            exceptionInfo.setMessage(e.getMessage());
            exceptionInfo.setCount(4);
            exceptionInfoDao.save(exceptionInfo);
            return null;
        } catch (InterruptedException e) {
            logger.info("test 其他异常信息" + e.getMessage());
            exceptionInfo.setMessage(e.getMessage());
            exceptionInfo.setCount(4);
            exceptionInfoDao.save(exceptionInfo);
            return null;
        } catch (Exception e) {
            logger.info("test 其他异常信息" + e.getMessage());
            exceptionInfo.setMessage(e.getMessage());
            exceptionInfo.setCount(4);
            exceptionInfoDao.save(exceptionInfo);
            return null;
        }
        return "true";
    }
}
