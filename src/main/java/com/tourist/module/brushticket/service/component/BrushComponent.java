package com.tourist.module.brushticket.service.component;

import com.alibaba.fastjson.JSONObject;
import com.tourist.module.brushticket.dao.ExceptionInfoDao;
import com.tourist.module.brushticket.dao.SuccessOrderInfoDao;
import com.tourist.module.brushticket.entity.BrushExceptionInfo;
import com.tourist.module.brushticket.entity.BrushTicketInfo;
import com.tourist.module.brushticket.entity.SuccessOrderInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author chenx 2019-02-22 10:11
 */
@Component
public class BrushComponent {

    private static final Logger logger = LoggerFactory.getLogger(BrushComponent.class);
    private static final String V_URL = "https://937707mltg.sjdzp.cn/Miniwx/Index/getOrdersVerify.json";
    private static final String CREATE_ORDER_URL = "https://937707mltg.sjdzp.cn/Miniwx/Index/orders.json";
    private static final String PAY_URL = "https://937707mltg.sjdzp.cn/Miniwx/Index/swiftPay.json?orders_id=";
    @Resource
    private ExceptionInfoDao exceptionInfoDao;
    @Resource
    private SuccessOrderInfoDao successOrderInfoDao;

    @Async
    public String getEwmUrl(BrushTicketInfo brushTicketDto, NameValuePair[] parameter, String mobile, Integer amount,String goodId) {
        logger.info(brushTicketDto.getHostName());
        BrushExceptionInfo exceptionInfo = new BrushExceptionInfo();
        exceptionInfo.setParameter(Arrays.toString(parameter));
        exceptionInfo.setCreateTime(new Date());
        try {
            //设置代理IP
            HttpHost proxy = new HttpHost(brushTicketDto.getHostName(), brushTicketDto.getPort(), "http");
            CloseableHttpClient httpclient = HttpClients
                    .custom()
                    .setDefaultCookieStore(new BasicCookieStore())
                    .setProxy(proxy)
                    .setConnectionTimeToLive(1000*3,TimeUnit.MILLISECONDS)
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
                    .setHeader("Referer", "https://937707mltg.sjdzp.cn/Miniwx/Index/buy.html?goods_id="+goodId+"&form=1&cc=1")
                    .setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                    .setHeader("X-Requested-With", "XMLHttpRequest")
                    .addParameter("verify_type", "1")
                    .build());
            String result = EntityUtils.toString(http1.getEntity());
            JSONObject verifyJson = JSONObject.parseObject(result);
            if (StringUtils.equalsIgnoreCase("false", verifyJson.getString("success"))) {
                //判断获取验证码结果
                String errorMessage = verifyJson.getString("message");
                exceptionInfo.setCount(1);
                exceptionInfo.setMessage(errorMessage);
                exceptionInfoDao.save(exceptionInfo);
                logger.info(errorMessage);
                return null;
            }
            String verify = JSONObject.parseObject(result).getString("verify");
//            String[] cookie1 = http1.getHeaders("Set-Cookie")[4].getValue().split(";")[0].split("=");
//            String[] sessid = http1.getHeaders("Set-Cookie")[0].getValue().split(";")[0].split("=");
            String cookie = http1.getHeaders("Set-Cookie")[4].getValue() + "; " + http1.getHeaders("Set-Cookie")[0].getValue();
            logger.info("------验证码-------：" + verify);
            logger.info("------cookie-------：" + cookie);
            logger.info("线程名称：" + Thread.currentThread().getName() + "-----" + brushTicketDto.getHostName());
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
                    .setHeader("Referer", "https://937707mltg.sjdzp.cn/Miniwx/Index/buy.html?goods_id="+goodId+"&form=1&cc=1")
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
                exceptionInfo.setMessage(errorMessage);
                exceptionInfo.setCount(2);
                exceptionInfoDao.save(exceptionInfo);
                logger.info(errorMessage);
                return errorMessage;
            }
            String auth_orders_id = JSONObject.parseObject(orderResult).getJSONObject("data").getString("auth_orders_id");
            logger.info("------------------auth_orders_id-------------" + auth_orders_id);
            exceptionInfo.setAuthOrdersId(auth_orders_id);
            http2.close();
            String payUrl = PAY_URL + auth_orders_id;
            Thread.sleep(1000*10);
            CloseableHttpResponse http3 = httpclient.execute(RequestBuilder.get(payUrl)
                    .setHeader("Accept", "application/json, text/javascript, */*; q=0.01")
                    .setHeader("Accept-Encoding", "gzip, deflate, br")
                    .setHeader("Accept-Language", "zh-CN,zh;q=0.9")
                    .setHeader("Connection", "keep-alive")
                    .setHeader("Cookie", cookie)
                    .setHeader("Host", "937707mltg.sjdzp.cn")
                    .setHeader("Referer", "https://937707mltg.sjdzp.cn/Miniwx/Index/orderInfo.html?orders_id="+auth_orders_id)
                    .setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                    .setHeader("X-Requested-With", "XMLHttpRequest")
                    .build());
            String payResult = EntityUtils.toString(http3.getEntity());
            JSONObject payJson = JSONObject.parseObject(payResult);
            if (StringUtils.equalsIgnoreCase("false", payJson.getString("success")) || StringUtils.equalsIgnoreCase("false", payJson.getString("wait"))) {
                //判断获取支付二维码结果
                String errorMessage = payJson.getString("message");
                exceptionInfo.setMessage(errorMessage);
                exceptionInfo.setCount(3);
                exceptionInfo.setGetEwmUrl(payUrl);
                exceptionInfoDao.save(exceptionInfo);
                System.out.println(errorMessage);
                return null;
            }
            String ewmUrl = JSONObject.parseObject(payResult).getJSONObject("data").getJSONObject("params").getString("wxpay_img_url");
            logger.info("-------------------二维码地址-------------" + ewmUrl);
            SuccessOrderInfo successOrderInfo = new SuccessOrderInfo();
            successOrderInfo.setEwmUrl(ewmUrl);
            successOrderInfo.setParameter(Arrays.toString(parameter));
            successOrderInfo.setMobile(mobile);
            successOrderInfo.setNumber(amount);
            successOrderInfo.setCreateTime(new Date());
            successOrderInfo.setOrderIdUrl(payUrl);
            successOrderInfoDao.save(successOrderInfo);
            httpclient.close();
        } catch (IOException e) {
            logger.info("其他异常信息" + e.getMessage());
            exceptionInfo.setMessage(e.getMessage());
            exceptionInfo.setCount(4);
            exceptionInfoDao.save(exceptionInfo);
        } catch (URISyntaxException e) {
            logger.info("其他异常信息" + e.getMessage());
            exceptionInfo.setMessage(e.getMessage());
            exceptionInfo.setCount(4);
            exceptionInfoDao.save(exceptionInfo);
        } catch (InterruptedException e) {
            logger.info("其他异常信息" + e.getMessage());
            exceptionInfo.setMessage(e.getMessage());
            exceptionInfo.setCount(4);
            exceptionInfoDao.save(exceptionInfo);
        } catch (Exception e) {
            logger.info("其他异常信息" + e.getMessage());
            exceptionInfo.setMessage(e.getMessage());
            exceptionInfo.setCount(4);
            exceptionInfoDao.save(exceptionInfo);
        }
        return null;
    }

    @Async
    public void test(BrushTicketInfo brushTicketDto) {
        logger.info("线程名称：" + Thread.currentThread().getName() + " ------" + "ip地址：" + brushTicketDto.getHostName() + "：" + brushTicketDto.getPort());
        try {
            Thread.sleep(1000 * 3);
            logger.info("线程名称：" + Thread.currentThread().getName() + " ------" + "ip地址：" + brushTicketDto.getHostName() + "：" + brushTicketDto.getPort());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void getEwm(){
        List<BrushExceptionInfo> list = exceptionInfoDao.findAllByCountOrderByCreateTimeDesc(3);
        list.forEach(brushExceptionInfo -> {
            BrushExceptionInfo exceptionInfo = new BrushExceptionInfo();
            CloseableHttpClient httpclient = HttpClients
                    .custom()
                    .setDefaultCookieStore(new BasicCookieStore())
                    .setConnectionTimeToLive(1000*3,TimeUnit.MILLISECONDS)
                    .build();
            try{
                CloseableHttpResponse http3 = httpclient.execute(RequestBuilder.get(brushExceptionInfo.getGetEwmUrl())
                        .setHeader("Accept", "application/json, text/javascript, */*; q=0.01")
                        .setHeader("Accept-Encoding", "gzip, deflate, br")
                        .setHeader("Accept-Language", "zh-CN,zh;q=0.9")
                        .setHeader("Connection", "keep-alive")
                        .setHeader("Cookie", brushExceptionInfo.getCookie())
                        .setHeader("Host", "937707mltg.sjdzp.cn")
                        .setHeader("Referer", "https://937707mltg.sjdzp.cn/Miniwx/Index/orderInfo.html?orders_id="+brushExceptionInfo.getAuthOrdersId())
                        .setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36")
                        .setHeader("X-Requested-With", "XMLHttpRequest")
                        .build());
                String payResult = EntityUtils.toString(http3.getEntity());
                JSONObject payJson = JSONObject.parseObject(payResult);
                if (StringUtils.equalsIgnoreCase("false", payJson.getString("success")) || StringUtils.equalsIgnoreCase("false", payJson.getString("wait"))) {
                    //判断获取支付二维码结果
                    String errorMessage = payJson.getString("message");
                    exceptionInfo.setMessage(errorMessage);
                    exceptionInfo.setCount(3);
                    exceptionInfo.setGetEwmUrl(brushExceptionInfo.getGetEwmUrl());
                    exceptionInfoDao.save(exceptionInfo);
                   logger.info("二次获取支付二维码失败"+errorMessage);
                    return ;
                }
                String ewmUrl = JSONObject.parseObject(payResult).getJSONObject("data").getJSONObject("params").getString("wxpay_img_url");
                logger.info("-------------------二维码地址-------------" + ewmUrl);
                SuccessOrderInfo successOrderInfo = new SuccessOrderInfo();
                successOrderInfo.setEwmUrl(ewmUrl);
                successOrderInfo.setParameter(brushExceptionInfo.getParameter());
                successOrderInfo.setMobile(brushExceptionInfo.getMobile());
                successOrderInfo.setNumber(brushExceptionInfo.getNumber());
                successOrderInfo.setOrderIdUrl(brushExceptionInfo.getGetEwmUrl());
                successOrderInfo.setCreateTime(new Date());
                successOrderInfoDao.save(successOrderInfo);
                httpclient.close();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
