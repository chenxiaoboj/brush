//package com.tourist.module.utils;
//
//import com.alibaba.fastjson.JSONObject;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.RequestBuilder;
//import org.apache.http.impl.client.BasicCookieStore;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import sun.misc.BASE64Encoder;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author chenxiaobo 2019-04-10 23:36
// */
//public class IdCardCheckUtil {
//
//    private static final String MORE_URL = "https://ocridcard.market.alicloudapi.com/idimages";
//    private static final String LESS_URL = "https://shenfenzhe.market.alicloudapi.com/do";
//    private static final String MORE_APPCODE = "f710d96be8fe45f4a64c2904eb5f5289";
//    private static final String LESS_APPCODE = "f710d96be8fe45f4a64c2904eb5f5289";
//    public static void main(String[] args) {
//        try{
//            CloseableHttpClient httpclient = HttpClients
//                    .custom()
//                    .setDefaultCookieStore(new BasicCookieStore())
//                    .setConnectionTimeToLive(1000 * 5, TimeUnit.MILLISECONDS)
//                    .build();
//            CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.post()
//                    .setUri(new URI(LESS_URL))
//                    .setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
//                    .setHeader("Authorization", "APPCODE " + LESS_APPCODE)
////                    .addParameter("idCardSide", "front")
////                    .addParameter("image", "data:image/jpeg;base64,"+getImageStr("D:\\image\\idcard.jpg"))
//                    .addParameter("detect_direction", "false")
//                    .addParameter("detect_risk", "false")
//                    .addParameter("id_card_side", "front")
//                    .addParameter("image", getImageStr("D:\\image\\idcard.jpg"))
//                    .build());
//            String result = EntityUtils.toString(http1.getEntity());
//            JSONObject verifyJson = JSONObject.parseObject(result);
//            System.out.println(verifyJson);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String getImageStr(String imgFile) {
//        InputStream inputStream = null;
//        byte[] data = null;
//        try {
//            inputStream = new FileInputStream(imgFile);
//            data = new byte[inputStream.available()];
//            inputStream.read(data);
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // 加密
//        BASE64Encoder encoder = new BASE64Encoder();
//        return encoder.encode(data);
//    }
//}
