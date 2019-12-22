//package com.lanjchenx.module.utils;
//
//import com.alibaba.fastjson.JSONObject;
//import org.apache.http.HttpEntity;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.RequestBuilder;
//import org.apache.http.entity.StringEntity;
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
//import java.util.HashMap;
//import java.util.Map;
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
////    private static final String LESS_APPCODE = "f710d96be8fe45f4a64c2904eb5f5289";
//    private static final String LESS_APPCODE = "f710d96be8fe45f4a64c2904eb5f5289";
//
//    public static void main(String[] args) throws IOException {
////        try {
////            CloseableHttpClient httpclient = HttpClients
////                    .custom()
////                    .setDefaultCookieStore(new BasicCookieStore())
////                    .setConnectionTimeToLive(1000 * 5, TimeUnit.MILLISECONDS)
////                    .build();
////            CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.post()
////                    .setUri(new URI(LESS_URL))
////                    .setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
////                    .setHeader("Authorization", "APPCODE " + LESS_APPCODE)
//////                    .addParameter("idCardSide", "front")
//////                    .addParameter("image", "data:image/jpeg;base64,"+getImageStr("D:\\image\\idcard.jpg"))
////                    .addParameter("detect_direction", "false")
////                    .addParameter("detect_risk", "false")
////                    .addParameter("id_card_side", "front")
////                    .addParameter("image", getImageStr("D:\\image\\idcard.jpg"))
////                    .build());
////            String result = EntityUtils.toString(http1.getEntity());
////            JSONObject verifyJson = JSONObject.parseObject(result);
////            System.out.println(verifyJson);
////        } catch (IOException e) {
////            e.printStackTrace();
////        } catch (URISyntaxException e) {
////            e.printStackTrace();
////        }
//
//        pictureCheck();
//    }
//
//
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
//
//    public static String pictureCheck() throws IOException {
//        CloseableHttpClient httpclient = HttpClients
//                .custom()
//                .setDefaultCookieStore(new BasicCookieStore())
//                .setConnectionTimeToLive(1000 * 5, TimeUnit.MILLISECONDS)
//                .build();
//        Map<String, String> querys = new HashMap<String, String>();
//        querys.put("image","iVBORw0KGgoAAAANSUhEUgAAACIAAAAsCAYAAAAATWqyAAAEYUlEQVR4nO2XTWwbRRTH/7M79m7WjvNlJ3Gc2HEaJxvnAI6FyoEiIaFyASRUqUJU4kSFQHxUCIREEVw4oNIDHJCqcuFQlSIOIHGAAwgkkKAFgURzsCXLFlk7isG1nTiOP/ZjOJB1tyb+bEV68P+yu2/mzf7mvTe7M8DdKrfb/UwoFPqa5/mRbvoLgnBEluWfPB7P84IghPp9L2d9IIRQj8fznMvlekSW5Z8FQVjsNIAoiksOh+N+v9//YTAYvEQpHb9tEMaYFo/Hj+Xz+SuiKMqyLF91Op0PthtgaGjoHgDI5XIXY7HYUU3T8v2AtBKZnZ09H41GWSQSqYyMjDzaqqMsy9cikcgepdTdaUxCCM9xnMjz/JggCIt2u32+0djOc25u7v3JycmXGWNaMpk8WSwWP7e2i6K4vLq6GutmZgcpnU6/ls1mzwNNqWmWoiivFIvFLwghdHZ29hwhxG5tn56efqNfCABQVXWz684cxw0Fg8HLdrvdb7ULgnBkbW1NDYfD19FhQs1aWlr6PhqNsrGxsROmjXZyMgyjkkqlnmoyk0Ag8BEhhG5ubr4NwOgFhDFW2b/qpq2nmZiampo6Mzw8/NDe3t5vzXXTJYgKAIQQvm+Q0dHRJ3w+33sAkMlkXgfA+gAxI9EAaaTG7/df8Hg8z7ZyXl9fX3Q4HPfNz89/TAjh8/n8Za/X+5bP5zun6/o2Y6zOGNMAMEIITwgRCCECpXSUUjqpKMqL+Xz+ihXEGpGONQIAmqbd0DQt53Q6H9A0LQeAUxTlpYWFhU8lSYp0M4aqqn8dYG5kpAFSKBQ+KxQKn1Sr1biu60XDMOoul+t4KBT6SlXVTV3Xtzc2Nl5Ip9Ov2u32eU3TbhiGUQOAeDx+bHd398eDAFZWVn6VJCmKWwuaNV1vgpRKpW9bzUbX9YJ5bxhGtVqtmh+xnusDAAghZiQacF0Vq2EYlX5e2EYcADDGegO507IU6X9TcztaXl7+oUcQAfj3b39HQbosViuIfR+kZtoOJTUcxwkAYK66QwO5ayJiqZH6oYJwHOcAbv0s/J+rprEb5Hl+uBmk54hMTEw8LYpiGLiZ625k7XsQSE8RcbvdpwOBwIWdnZ1vEonE45TSMaC75Wv25TjOYamRnkHIzMzMO16v9ywAqKqaBQBK6WQnx1qtliCEiIQQ275P49yj63q5JxCXy/Wwy+U6DsDIZDJnt7a23gWAZDJ5khBiq1Qqf7TyTSaTT1qfzUPb/h6msXzbgkiSdO/+LafreimVSp3a3t7+0mwvl8tX2/nbbDYfAKaq6hYAw2azzXi93jcBoBm+JUgwGLw0Pj5+CgDq9fqfiUTisUqlcr3di5vFGKuHw+HfKaXTjDGV4zjRbDN3a6ZarhpFUc5Uq9VYuVy+FovFjvYKAQCapv2dzWY/ME94VohcLnfR2rftSU8QhKCqqlnDMPZ6hTAlSVLU7XafZozVVFXNlEql78rl8i/9jjfQQAMNNNBA/eofcv3P8EFJTSEAAAAASUVORK5CYII=");
//        querys.put("configure","{\"template_id\":\"95d551ee-8b2b-4ad0-89a9-ed13417f4a781536146904\"}");
//        HttpEntity stringEntity = new StringEntity(JSONObject.toJSONString(querys));
//        CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.post()
//                .setUri("http://ocrdiy.market.alicloudapi.com/api/predict/ocr_sdt")
//                .setHeader("Content-Type", "application/json; charset=UTF-8")
//                .setHeader("Authorization", "APPCODE " + LESS_APPCODE)
//                .setEntity(stringEntity)
//                .build());
//        String result = EntityUtils.toString(http1.getEntity());
//        JSONObject verifyJson = JSONObject.parseObject(result);
//        System.out.println(result);
//        return null;
//    }
//
//}
