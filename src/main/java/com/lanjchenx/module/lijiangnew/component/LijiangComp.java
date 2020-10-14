package com.lanjchenx.module.lijiangnew.component;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lanjchenx.module.lijiangnew.dao.LijiangValidateInfoDao;
import com.lanjchenx.module.lijiangnew.dto.*;
import com.lanjchenx.module.utils.RetryUtil;
import com.lanjchenx.utils.ArithUtil;
import com.lanjchenx.utils.MD5Utils;
import com.lanjchenx.module.lijiangnew.dao.LijiangParameterInfoDao;
import com.lanjchenx.module.lijiangnew.entity.LijiangParameterInfo;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author admin 2019-04-25 22:51
 */
@Component
public class LijiangComp {
    private static final Logger logger = LoggerFactory.getLogger(LijiangComp.class);

    private static final ArrayList<Header> headers = new ArrayList<Header>();

    @Resource
    private LijiangParameterInfoDao lijiangParameterInfoDao;
    @Resource
    private LijiangValidateInfoDao lijiangValidateInfoDao;


    //登录地址
    private static final String LOGIN_URL = "https://mallwx.ltg.cn/loginAction/login";
    //上传图片地址
    private static final String UPLOAD_IMAGE_URL = "https://mallwx.ltg.cn/uploadFileAction/front/privateAuthority/uploadDetectLiveFace";
    //获取常用联系人地址
    private static final String CONTACTS = "https://mallwx.ltg.cn/individualFrequentContactsInterface/front/privateAuthority/findIndividualFrequentContactsListByUserId";
    //下系统订单地址
    private static final String SAVE_ORDER = "https://mallwx.ltg.cn/productReservationAction/front/privateAuthority/saveOrder";
    //下微信支付订单接口
    private static final String PAY_ORDER = "https://mallwx.ltg.cn/productReservationAction/front/privateAuthority/payOrder";
    //删除联系人
    private static final String DELETE_CONTACTS = "https://mallwx.ltg.cn/individualFrequentContactsInterface/front/privateAuthority/deleteIndividualFrequentContacts";
    //添加联系人
    private static final String ADD_CONTACTS = "https://mallwx.ltg.cn/individualFrequentContactsInterface/front/privateAuthority/addIndividualFrequentContacts";
    //获取时间段
    private static final String GET_TIME = "https://mallwx.ltg.cn/timeAndPerformanceAction/findScenicSpotsTime";
    //获取支付宝订单链接
    private static final String ALI_PAY_QR_CODE = "https://mallwx.ltg.cn/productReservationAction/front/privateAuthority/payOrder";
    //下单排队重查地址
    private static final String FIND_CREATE_ORDER = "https://mallwx.ltg.cn/individualFrequentContactsInterface/front/privateAuthority/addIndividualFrequentContacts";

    static {
        headers.add(new BasicHeader("Host", "mallwx.ltg.cn"));
        headers.add(new BasicHeader("Content-Type", "application/json"));
        headers.add(new BasicHeader("Accept-Encoding", "br, gzip, deflate"));
//        headers.add(new BasicHeader("Cookie", "JSESSIONID=8D284FC7D9650C1A60F8582C3D588FAD; acw_tc=76b20ff615566185613821012e66cd136d41010c89bcae4568c8dfa1d345b4"));
        headers.add(new BasicHeader("Connection", "keep-alive"));
        headers.add(new BasicHeader("Accept", "*/*"));
        headers.add(new BasicHeader("User-Agent", "demo/1.4.8 (iPhone; iOS 12.2; Scale/2.00)"));
        headers.add(new BasicHeader("Accept-Language", "zh-Hans-CN;q=1"));
        headers.add(new BasicHeader("X-Requested-With", "XMLHttpRequest"));
    }

    public static void main(String[] args) throws HttpException, IOException {
//        Long begin = System.currentTimeMillis();
        Map<String, Integer> time = new LijiangComp().getTimes(LocalDate.now().plusDays(3).toString());
        System.out.println(time);
//        List<Map.Entry<String, Integer>> list = new ArrayList(time.entrySet());
//        Collections.sort(list, (o2, o1) -> (o1.getValue() - o2.getValue()));
//        Long end = System.currentTimeMillis();
//        System.out.println(end - begin);
//        System.out.println(list.get(0));
//        Map<String, String> map = Maps.newHashMap();
//        map.put("13067518343", "100106");
//        map.forEach((key, value) -> {
//            String token = new LijiangComp().login(new AccountNumberDto(key, value));
//            List<String> ids = new LijiangComp().getContacts(token);
//            ids.forEach(s -> {
//                try {
//                    Thread.sleep(1000);
//                    new LijiangComp().deleteContacts(token, s);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        });
        String token = " eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIzYmM3MDY2Mi1iMzUzLTQ5MTEtYjhlOC0wODNjOGQyYmU0MjkiLCJpYXQiOjE1ODUzMDQwMTksImlzcyI6ImRlbW8iLCJzdWIiOiJ7XCJjZWxscGhvbmVcIjpcIjEzNjM0NTkzNDAyXCIsXCJlbWFpbFwiOlwiXCIsXCJmbGFnXCI6XCJZXCIsXCJuaWNrTmFtZVwiOlwiXCIsXCJwYXNzd29yZFwiOlwib1o3K0VCTUZxWlZTRjYybXpIa3Z4QT09XCIsXCJ1c2VySWRcIjoxMDAwMDAwMDI5ODI0NCxcInVzZXJOYW1lXCI6XCIxMzYzNDU5MzQwMlwiLFwidXNlclBob3RvVVJMXCI6XCJodHRwczovL21hbGxpbnRlci5sdGcuY246Mjg4NjYvXCIsXCJ1c2VyVHlwZVwiOlwiMVwifSJ9.UhiBDUQBC-KGJKH56CAA3uw7O74_O7nND367WoDaNpc";
        new LijiangComp().getQRCode(token, "77527050614034",1);
    }

    public static String getMaxTime() {
        Long begin = System.currentTimeMillis();
        Map<String, Integer> time = new LijiangComp().getTimes(LocalDate.now().plusDays(1).toString());
        List<Map.Entry<String, Integer>> list = new ArrayList(time.entrySet());
        list.sort((o2, o1) -> (o1.getValue() - o2.getValue()));
        Long end = System.currentTimeMillis();
        logger.info("获取时间段耗时:{}", end - begin);
        logger.info("当前最大票量为:{}", list.get(0).getValue());
        return list.get(0).getKey();
    }

    /**
     * 上传照片（需要token）
     *
     * @param file
     * @return
     * @throws IOException
     */
    public String httpClientUploadFile(MultipartFile file, String token) throws IOException {
        String string = "" + System.currentTimeMillis();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        String imageUrl = "";
        try {
            String fileName = file.getOriginalFilename();
            HttpPost httpPost = new HttpPost(UPLOAD_IMAGE_URL);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            String sign = MD5Utils.MD5(token).toLowerCase();
            builder.addBinaryBody("file", file.getInputStream(), ContentType.parse("image/jpg"), fileName);// 文件流
            builder.addTextBody("filename", fileName);// 类似浏览器表单提交，对应input的name和value
            builder.setBoundary(string);
            HttpEntity entity = builder.build();
            httpPost.setHeaders(headers.toArray(new Header[headers.size()]));
            httpPost.setHeader("Accept-Encoding", "gzip");
            httpPost.setHeader("token", token);
            httpPost.setHeader("sign", sign);
            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=" + string);
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);// 执行提交
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                // 将响应内容转换为字符串
                result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
                logger.info("上传图片接口返回数据:{}", result);
                JSONObject jsonObject = JSONObject.parseObject(result);
                if (StringUtils.equalsIgnoreCase("200", jsonObject.getString("code")) &&
                        StringUtils.equalsIgnoreCase("上传成功", jsonObject.getString("message"))) {
                    imageUrl = jsonObject.getJSONObject("data").getJSONArray("initialPreview").get(0).toString();
                    logger.info("返回图片地址:{}", imageUrl);
                } else {
                    imageUrl = jsonObject.getString("message");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageUrl;
    }

    /**
     * 登录接口
     *
     * @param accountNumber
     * @return
     */
    public String login(AccountNumberDto accountNumber) {
        try {
            CloseableHttpClient httpclient = HttpClients
                    .custom()
                    .setDefaultCookieStore(new BasicCookieStore())
                    .setConnectionTimeToLive(1000 * 5, TimeUnit.MILLISECONDS)
                    .setDefaultHeaders(headers)
                    .build();
            logger.info("------------------账号登录------------:{}", accountNumber.getUserName());
            HttpEntity httpEntity = new StringEntity(JSONObject.toJSONString(accountNumber));
            CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.post()
                    .setUri(LOGIN_URL)
                    .setEntity(httpEntity)
                    .build());
            String result = EntityUtils.toString(http1.getEntity());
            logger.info("账号登录返回数据:{}", result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            String token = "";
            if (StringUtils.equalsIgnoreCase("200", jsonObject.getString("code")) &&
                    StringUtils.equalsIgnoreCase("登录成功", jsonObject.getString("message"))) {
                token = jsonObject.getJSONObject("data").getString("token");
                logger.info("返回token:{}", token);
            }
            http1.close();
            httpclient.close();
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取常用联系人信息（需要token）
     *
     * @param token
     * @return
     * @throws IOException
     */
    public List<String> getContacts(String token) {
        try {
            List<String> contactsList = Lists.newArrayList();
            CloseableHttpClient httpclient = HttpClients
                    .custom()
                    .setDefaultCookieStore(new BasicCookieStore())
                    .setConnectionTimeToLive(1000 * 5, TimeUnit.MILLISECONDS)
                    .setDefaultHeaders(headers)
                    .build();
            logger.info("------------------获取常用联系人信息------------");
            CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.post()
                    .setUri(CONTACTS)
                    .setEntity(new StringEntity("{}"))
                    .setHeader("token", token)
                    .build());
            String result = EntityUtils.toString(http1.getEntity());
            logger.info("获取常用联系人信息返回信息:{}", result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (StringUtils.equalsIgnoreCase("200", jsonObject.getString("code")) &&
                    StringUtils.equalsIgnoreCase("获取常用联系人成功", jsonObject.getString("message"))) {
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                jsonArray.forEach(o -> {
                    JSONObject contacts = (JSONObject) o;
                    contactsList.add(contacts.getString("individualFrequentContactsId"));
                });
                logger.info("常用联系人id组:{}", contactsList);
            }
            http1.close();
            httpclient.close();
            return contactsList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取常用联系人信息（需要token）
     *
     * @param token
     * @return
     * @throws IOException
     */
    @Async
    @Transactional
    public void getQRCode(String token, String orderBatchNO, Integer id) {
        try {
            Map<String, String> orderMap = Maps.newHashMap();
            orderMap.put("paymentTypeId", "3");
            orderMap.put("orderBatchNO", orderBatchNO);
            List<String> contactsList = Lists.newArrayList();
            CloseableHttpClient httpclient = HttpClients
                    .custom()
                    .setDefaultCookieStore(new BasicCookieStore())
                    .setConnectionTimeToLive(1000 * 5, TimeUnit.MILLISECONDS)
                    .setDefaultHeaders(headers)
                    .build();
            logger.info("------------------获取订单链接------------");
            CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.post()
                    .setUri(ALI_PAY_QR_CODE)
                    .setEntity(new StringEntity(JSONObject.toJSONString(orderMap)))
                    .setHeader("token", token)
                    .build());
            String result = EntityUtils.toString(http1.getEntity());
            logger.info("获取订单链接返回信息:{}", result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (StringUtils.equalsIgnoreCase("200", jsonObject.getString("code")) &&
                    StringUtils.equalsIgnoreCase("app支付创建成功", jsonObject.getString("message"))) {
                JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                String redirectUrl = jsonObject1.getJSONObject("redirectUrl").getString("qrCode");
                logger.info("该订单返回链接为:{}", redirectUrl);
                lijiangParameterInfoDao.updateUrl(redirectUrl, id);
            } else {
                logger.info("--------------------获取订单链接信息错误-------------------");
            }
            http1.close();
            httpclient.close();
        } catch (Exception e) {
            logger.info("--------------------获取订单链接信息异常-------------------");
            e.printStackTrace();
        }
    }

    /**
     * 提交订单 + 提交支付信息接口（需要token）
     *
     * @param token
     * @param parameter
     * @return
     */
    @Async
    @Transactional
    public void saveOrder(String token, String parameter, Integer id) {
//        logger.info("ip:{}",brushTicketInfo.getHostName()+":"+brushTicketInfo.getPort());
        try {
//            HttpHost proxy = new HttpHost(brushTicketInfo.getHostName(), brushTicketInfo.getPort(), "http");
            CloseableHttpClient httpclient = HttpClients
                    .custom()
                    .setDefaultCookieStore(new BasicCookieStore())
//                    .setProxy(proxy)
                    .setConnectionTimeToLive(1000 * 5, TimeUnit.MILLISECONDS)
                    .setDefaultHeaders(headers)
                    .build();
            logger.info("------------------创建订单----------------");
            HttpPost post = new HttpPost(SAVE_ORDER);
            post.setHeader("token", token);
            post.setHeader("iosUUID", UUID.randomUUID().toString().toUpperCase());
            StringEntity s = new StringEntity(parameter, "UTF-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
//            CloseableHttpResponse http1 = httpclient.execute(post);
            CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.post()
                    .setUri(SAVE_ORDER)
                    .setHeader("token", token)
                    .setEntity(s)
                    .build());
            String result = EntityUtils.toString(http1.getEntity());
            logger.info("创建订单返回数据:{}", result);
            JSONObject jsonObject = JSONObject.parseObject(result);
//            this.findCreateOrder(token,parameter,id,15);
            String message = jsonObject.getString("message");
            if (StringUtils.equalsIgnoreCase("200", jsonObject.getString("code"))) {
                String orderBatchNO = jsonObject.getJSONObject("data").getString("orderBatchNO");
                lijiangParameterInfoDao.updateStatus(1, id, message, orderBatchNO);
                logger.info("-------------提交订单成功----------修改状态，保存订单号");
            } else {
                lijiangParameterInfoDao.updateStatus(0, id, message,"");
            }
            http1.close();
            httpclient.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            logger.info("提交订单异常");
        }
    }

    /**
     * 提交订单 + 提交支付信息接口（需要token）
     *
     * @param token
     * @param parameter
     * @return
     */
    @Async
    @Transactional
    public void saveOrder2(String token, String parameter, Integer id) {
//        logger.info("ip:{}",brushTicketInfo.getHostName()+":"+brushTicketInfo.getPort());
        try {
//            HttpHost proxy = new HttpHost(brushTicketInfo.getHostName(), brushTicketInfo.getPort(), "http");
            CloseableHttpClient httpclient = HttpClients
                    .custom()
                    .setDefaultCookieStore(new BasicCookieStore())
//                    .setProxy(proxy)
                    .setConnectionTimeToLive(1000 * 5, TimeUnit.MILLISECONDS)
                    .setDefaultHeaders(headers)
                    .build();
            logger.info("------------------创建订单----------------");
            HttpPost post = new HttpPost(SAVE_ORDER);
            post.setHeader("token", token);
            post.setHeader("iosUUID", UUID.randomUUID().toString().toUpperCase());
            StringEntity s = new StringEntity(parameter, "UTF-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.post()
                    .setUri(SAVE_ORDER)
                    .setHeader("token", token)
                    .setEntity(s)
                    .build());
            String result = EntityUtils.toString(http1.getEntity());
            logger.info("创建订单返回数据:{}", result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            String code = jsonObject.getString("code");
            if (StringUtils.equalsIgnoreCase("200", code)) {
                String message = jsonObject.getString("message");
                // 获取订单号
                String orderBatchNO = jsonObject.getJSONObject("data").getString("orderBatchNO");
                lijiangParameterInfoDao.updateStatus(1, id, message, orderBatchNO);
                logger.info("-------------提交订单成功----------修改状态");
            } else {
                //获取最新验证码
                RetryUtil retryUtil = new RetryUtil();
                RetryUtil.setRetryTimes(10);
                Parameter2 parameter2 = JSONObject.parseObject(parameter, Parameter2.class);
                //TODO  如果订单中有人已经定过，去除该人
                if (StringUtils.equalsIgnoreCase("50025", code)) {
                    logger.info("-------------提交订单失败，进入重试，删除已定票联系人----------");
                    Parameter2.OrderItemsList orderItemsList = parameter2.getOrderItemsList().get(0);
                    orderItemsList.setSaleSum((Integer.parseInt(orderItemsList.getSaleSum()) - 1) + "");
                    List<Parameter2.OrderItemsList.OrderCertificateItemsList> listAll = orderItemsList.getOrderCertificateItemsList();
                    List<Parameter2.OrderItemsList.OrderCertificateItemsList> list = listAll.stream()
                            .filter(user -> StringUtils.equals("", user.getCertificateNo())).collect(Collectors.toList());
                    Parameter2.OrderItemsList.OrderCertificateItemsList orderCertificateItemsList = list.get(0);
                    listAll.remove(orderCertificateItemsList);
                    if (StringUtils.equals(parameter2.getOrderTackTicketName(), orderCertificateItemsList.getCertificateName())) {
                        parameter2.setOrderTackTicketName(listAll.get(0).getCertificateName());
                        parameter2.setOrderTackTicketPhone(listAll.get(0).getPhoneNumber());
                    }
                    orderItemsList.setOrderCertificateItemsList(listAll);
                } else if (StringUtils.equalsIgnoreCase("666666", code)) {
                    logger.info("-------------提交订单失败，票量不足，获取最新票量信息----------");
                    //TODO 获取最新最高 时间段漂亮
                    parameter2.getOrderTimeControlList().get(0).setTimeControlDetailId(getMaxTime());
                }
                String validate = lijiangValidateInfoDao.getOneValidate();
                parameter2.setValidate(validate);
                retryUtil.retry(token, JSONObject.toJSONString(parameter2), id);
            }
            http1.close();
            httpclient.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            logger.info("--------------提交订单异常，重新提交------------------");
        }
    }


    /**
     * 删除联系人（需要token）
     */
    public void deleteContacts(String token, String individualFrequentContactsId) {
        try {
            Thread.sleep(1000 * 2);
            List<String> contactsList = Lists.newArrayList();
            CloseableHttpClient httpclient = HttpClients
                    .custom()
                    .setDefaultCookieStore(new BasicCookieStore())
                    .setConnectionTimeToLive(1000 * 5, TimeUnit.MILLISECONDS)
                    .setDefaultHeaders(headers)
                    .build();
            logger.info("------------------删除联系人------------");
            HttpEntity httpEntity = new StringEntity("{\"individualFrequentContactsId\":\"" + individualFrequentContactsId + "\"}");
            CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.post()
                    .setUri(DELETE_CONTACTS)
                    .setHeader("token", token)
                    .setEntity(httpEntity)
                    .build());
            String result = EntityUtils.toString(http1.getEntity());
            logger.info("删除联系人返回信息:{}", result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (StringUtils.equalsIgnoreCase("200", jsonObject.getString("code")) &&
                    StringUtils.equalsIgnoreCase("删除常用联系人成功", jsonObject.getString("message"))) {
                logger.info("-------------删除联系人成功----------", contactsList);
            }
            http1.close();
            httpclient.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("-------------删除联系人失败----------");
        }
    }

    /**
     * 添加联系人（需要token）
     */
    public String addContacts(String token, ContactsDto contactsDto) {
        try {
            Thread.sleep(1000 * 2);
            List<String> contactsList = Lists.newArrayList();
            CloseableHttpClient httpclient = HttpClients
                    .custom()
                    .setDefaultCookieStore(new BasicCookieStore())
                    .setConnectionTimeToLive(1000 * 5, TimeUnit.MILLISECONDS)
                    .setDefaultHeaders(headers)
                    .build();
            logger.info("------------------保存常用联系人------------");
            HttpPost post = new HttpPost(ADD_CONTACTS);
            post.setHeader("token", token);
            StringEntity s = new StringEntity(JSONObject.toJSONString(contactsDto), "UTF-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            CloseableHttpResponse http1 = httpclient.execute(post);
            String result = EntityUtils.toString(http1.getEntity());
            logger.info("保存常用联系人返回信息:{}", result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            http1.close();
            httpclient.close();
            if (StringUtils.equalsIgnoreCase("200", jsonObject.getString("code")) &&
                    StringUtils.equalsIgnoreCase("保存常用联系人成功", jsonObject.getString("message"))) {
                logger.info("-------------保存常用联系人成功----------", contactsList);
                return "200";
            } else {
                return jsonObject.getString("message");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取时间段
     *
     * @throws IOException
     */
    public Map<String, Integer> getTimes(String time) {
        try {
            Map<String, Integer> timeMap = Maps.newHashMap();
            CloseableHttpClient httpclient = HttpClients
                    .custom()
                    .setDefaultCookieStore(new BasicCookieStore())
                    .setConnectionTimeToLive(1000 * 5, TimeUnit.MILLISECONDS)
                    .setDefaultHeaders(headers)
                    .build();
            logger.info("------------------获取时间段------------");
            HttpEntity httpEntity = new StringEntity(JSONObject.toJSONString(
                    new TimeDto("1", "XSSKKC",
                            time,
//                            LocalDate.now().minusDays(1) + "",
                            "10000000000002", "XCXGP")));
            CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.post()
                    .setUri(GET_TIME)
                    .setEntity(httpEntity)
                    .build());
            String result = EntityUtils.toString(http1.getEntity());
            logger.info("获取时间段:{}", result);
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (StringUtils.equalsIgnoreCase("200", jsonObject.getString("code")) &&
                    StringUtils.equalsIgnoreCase("获取景点时段信息成功", jsonObject.getString("message"))) {
                JSONArray timeDetailList = jsonObject.getJSONObject("data").getJSONArray("timeDetailList");
                timeDetailList.forEach(timeDate -> {
                    JSONObject timeDateJson = (JSONObject) timeDate;
                    String timeControlDetailId = timeDateJson.getString("timeControlDetailId");
                    Integer surplus = timeDateJson.getInteger("totalSum") - timeDateJson.getInteger("saleSum");
                    if (surplus >= 5) {
                        timeMap.put(timeControlDetailId, surplus);
                    }
                });
                logger.info("-------------获取景点时段信息成功----------");
            }
            http1.close();
            httpclient.close();
            return timeMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    /**
//     * 排队中检索订单 （需要token）
//     *
//     * @param token
//     * @param parameter
//     * @return
//     */
//    @Async
//    @Transactional
//    public void findCreateOrder(String token, String parameter, Integer id, int findCreateIndex) {
//        JSONObject jsonParameter = JSONObject.parseObject(parameter);
//        String uuid = jsonParameter.getString("createOrderUuid");
//        logger.info("重新下单请求所需UUID:" + uuid);
//        //发送get
//        try {
//            CloseableHttpClient httpclient = HttpClients
//                    .custom()
//                    .setDefaultCookieStore(new BasicCookieStore())
//                    .setConnectionTimeToLive(1000 * 5, TimeUnit.MILLISECONDS)
//                    .setDefaultHeaders(headers)
//                    .build();
//            logger.info("------------------查询---------------【" + findCreateIndex + "】");
//            CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.get()
//                    .setUri(FIND_CREATE_ORDER + "?createOrderUuid=" + uuid)
//                    .setHeader("token", token)
//                    .build());
//            String result = EntityUtils.toString(http1.getEntity());
//            logger.info("查询下单状态返回:{}", result);
//            JSONObject jsonObject = JSONObject.parseObject(result);
//            if (StringUtils.equalsIgnoreCase("200", jsonObject.getString("code"))) {
//                lijiangParameterInfoDao.updateStatus(id);
//                logger.info("-------------查询下单状态----订单成功----------修改状态");
//            } else if (StringUtils.equalsIgnoreCase("500", jsonObject.getString("code"))) {
//                //lijiangParameterInfoDao.updateStatus(id);
//                logger.info("-------------未出票成功----------再次检测:【" + findCreateIndex + "】");
//                Thread.sleep(1000 * 1);
//                findCreateIndex--;
//                if (findCreateIndex > 0) {
//                    findCreateOrder(token, parameter, id, findCreateIndex);
//                }
//            }
//            http1.close();
//            httpclient.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.info(e.getMessage());
//            logger.info("提交订单异常");
//        }
//    }

    /**
     * 返回系数
     *
     * @param map
     * @return
     */
    public Double coefficient(Map<String, Integer> map, List<LijiangParameterInfo> lijiangParameterInfos) {
        AtomicReference<Integer> ticketCount = new AtomicReference<>(0);
        map.forEach((key, value) -> {
            ticketCount.updateAndGet(v -> v + value);
        });
        logger.info("今天票量：{}" + ticketCount.get());
        AtomicReference<Integer> peopleCount = new AtomicReference<>(0);
        if (ticketCount.get() == 0) {
            return 0.0;
        }
        lijiangParameterInfos.forEach(lijiangParameterInfo -> {
            peopleCount.updateAndGet(v -> v + lijiangParameterInfo.getCountNumber());
        });
        logger.info("当前抢票总人数：{}" + peopleCount.get());
        Double coefficient = ArithUtil.div(peopleCount.get(), ticketCount.get());
        logger.info("系数：{}" + coefficient);
        return coefficient;
    }


}
