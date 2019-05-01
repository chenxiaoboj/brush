package com.tourist.module.brushticket.service.component;

import org.apache.commons.httpclient.HttpException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.mock.web.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * @author admin 2019-04-25 22:51
 */
public class Test {

    public static void main(String[] args) throws HttpException, IOException {
//        getHomePage();
//        upload();
        httpClientUploadFile(null);

    }

    public static void getHomePage() throws HttpException, IOException {
        CloseableHttpClient httpclient = HttpClients
                .custom()
                .setDefaultCookieStore(new BasicCookieStore())
                .setConnectionTimeToLive(1000 * 3, TimeUnit.MILLISECONDS)
                .build();
        StringEntity se = new StringEntity("{\"orderNetType\":\"XCXGP\",\"orderTackTicketName\":\"王小康\",\"orderTackTicketPhone\":\"15601708566\",\"arriveDT\":\"2019-04-25\",\"certificateTypeNo\":\"410222199209142015\",\"remark\":\"\",\"orderItemsList\":[{\"productOnlyNo\":\"10000008028\",\"saleSum\":1,\"orderCertificateItemsList\":[{\"certificateNo\":\"410222199209142015\",\"certificateCardName\":\"身份证\",\"certificateName\":\"王小康\",\"certificateTypeId\":1,\"phoneNumber\":\"15601708566\",\"facePicPath\":\"https://mallinter.ltg.cn:28866/group1/M00/00/11/rBDUslzBbn-AGWlhAASeqPl4_iI55..jpg\"}]}],\"orderTimeControlList\":[]}");
//        se.setContentType(CONTENT_TYPE_TEXT_JSON);
        CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.post()
                .setUri("https://mallwx.ltg.cn/productReservationAction/front/privateAuthority/saveOrder")
                .setHeader("charset", "utf-8")
                .setHeader("Accept-Encoding", "gzip")
                .setHeader("referer", "https://servicewechat.com/wx2fd91fc20b4d1376/6/page-frame.html")
                .setHeader("x-requested-with", "XMLHttpRequest")
                .setHeader("token", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmYWNlNzZlMy0yOTZmLTRjYTUtYmY5Zi1lZGQ3ODAwNTBkMDkiLCJpYXQiOjE1NTYyMDMxMTIsImlzcyI6ImRlbW8iLCJzdWIiOiJ7XCJjZWxscGhvbmVcIjpcIlwiLFwiZW1haWxcIjpcIlwiLFwibmlja05hbWVcIjpcIktpbmdcIixcIm9wZW5pZFwiOlwib3ZVNFo0MXRIOVphalRMNnhfWHpJOVIxRldwVVwiLFwidXNlcklkXCI6MTAwMDAwMDAwMDMzOTgsXCJ1c2VyTmFtZVwiOlwiXCIsXCJ1c2VyUGhvdG9VUkxcIjpcImh0dHBzOi8vd3gucWxvZ28uY24vbW1vcGVuL3ZpXzMyL0RZQUlPZ3E4M2VyMnk3c2NZVXlxNExvbTNEUmdGWlk4eEFQM0lYclFBaWNta28wTElPWHd3MlE5U2RPZG9oVFB4M052ZTNrc3E5RU9Ob1NpYU5DUmFVNFEvMTMyXCIsXCJ1c2VyVHlwZVwiOlwiM1wifSJ9.GCs6zaP2bNOKI6GTSRWhq-B-LW5dhsGHOVoFiwlKXdo")
                .setHeader("Content-Type", "application/json")
                .setHeader("User-Agent", "Mozilla/5.0 (Linux; Android 7.0; SM-G9350 Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/64.0.3282.137 Mobile Safari/537.36 MicroMessenger/6.7.3.1360(0x26070333) NetType/WIFI Language/zh_CN Process/appbrand0")
                .setHeader("Host", "mallwx.ltg.cn")
                .setHeader("Connection", "Keep-Alive")
                .setEntity(se)
                .addParameter("verify_type", "1")
                .build());
        String result = EntityUtils.toString(http1.getEntity());
        System.out.printf(result);
        http1.close();
        httpclient.close();
    }

    public static void upload() throws HttpException, IOException {
        HttpHost proxy = new HttpHost("192.168.3.3", 8888);
        CloseableHttpClient httpclient = HttpClients
                .custom()
                .setDefaultCookieStore(new BasicCookieStore())
//                .setProxy(proxy)
                .setConnectionTimeToLive(1000 * 3, TimeUnit.MILLISECONDS)
                .build();
        FileEntity fileEntity = new FileEntity(new File("D:\\GIT目录备份\\ideaProject\\1556283810.jpg"));
        fileEntity.setContentType("image/jpg");

        File file = new File("D:\\GIT目录备份\\ideaProject\\1556283810.jpg");//图片
        FileInputStream fis = new FileInputStream(file);
        InputStreamEntity inputStreamEntity = new InputStreamEntity(fis);
//        inputStreamEntity.
        System.out.println(System.currentTimeMillis());
        CloseableHttpResponse http1 = httpclient.execute(RequestBuilder.post()
                .setUri("https://mallwx.ltg.cn//uploadFileAction/front/privateAuthority/uploadDetectLiveFace")
                .setHeader("Connection", "Keep-Alive")
                .setHeader("Accept-Encoding", "gzip")
                .setHeader("referer", "https://servicewechat.com/wx2fd91fc20b4d1376/6/page-frame.html")
                .setHeader("token", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI1YjNjYTI4Mi1hMjk0LTQzMTUtOTI2Mi1jMTM3YjQwY2MwNDAiLCJpYXQiOjE1NTYyNjg5MDEsImlzcyI6ImRlbW8iLCJzdWIiOiJ7XCJjZWxscGhvbmVcIjpcIlwiLFwiZW1haWxcIjpcIlwiLFwibmlja05hbWVcIjpcIktpbmdcIixcIm9wZW5pZFwiOlwib3ZVNFo0MXRIOVphalRMNnhfWHpJOVIxRldwVVwiLFwidXNlcklkXCI6MTAwMDAwMDAwMDMzOTgsXCJ1c2VyTmFtZVwiOlwiXCIsXCJ1c2VyUGhvdG9VUkxcIjpcImh0dHBzOi8vd3gucWxvZ28uY24vbW1vcGVuL3ZpXzMyL0RZQUlPZ3E4M2VyMnk3c2NZVXlxNExvbTNEUmdGWlk4eEFQM0lYclFBaWNta28wTElPWHd3MlE5U2RPZG9oVFB4M052ZTNrc3E5RU9Ob1NpYU5DUmFVNFEvMTMyXCIsXCJ1c2VyVHlwZVwiOlwiM1wifSJ9.8A-971_kcV0aXCJ7pjHpuh0xyp-hQbuIbfJ0Ch9J9pk")
                .setHeader("User-Agent", "Mozilla/5.0 (Linux; Android 7.0; SM-G9350 Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/64.0.3282.137 Mobile Safari/537.36 MicroMessenger/6.7.3.1360(0x26070333) NetType/WIFI Language/zh_CN Process/appbrand0")
                .setHeader("Content-Type", "multipart/form-data; boundary=" + (System.currentTimeMillis() + 30))
//                .setHeader("Content-Type","multipart/form-data; boundary=111")
                .setHeader("Host", "mallwx.ltg.cn")
                .setEntity(fileEntity)
//                .addParameter("Content-Disposition","form-data; name=\"paramPath\"")
//                .addParameter("file","1556283810.jpg")
//                .addParameter("Content-Disposition","form-data")
//                .addParameter("name","paramPath")
//                .addParameter("file","1556283810.jpg")
                .build());
        String result = EntityUtils.toString(http1.getEntity());
        System.out.printf(result);
        http1.close();
        httpclient.close();
    }

    public static String httpClientUploadFile(MultipartFile file1) throws IOException {
        String string = "" + System.currentTimeMillis();
        String filePath = "D:\\GIT目录备份\\ideaProject\\1556283810.jpg";
        File file2 = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file2);
        MultipartFile file = new MockMultipartFile("copy" + file2.getName(), file2.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
        System.out.println(file.getName()); // 输出copytest.txt
        final String remote_url = "https://mallwx.ltg.cn//uploadFileAction/front/privateAuthority/uploadDetectLiveFace";// 第三方服务器请求地址
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        try {
            String fileName = file.getOriginalFilename();
            HttpPost httpPost = new HttpPost(remote_url);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("file", file.getInputStream(), ContentType.parse("image/jpg"), fileName);// 文件流
            builder.addTextBody("filename", fileName);// 类似浏览器表单提交，对应input的name和value
            builder.setBoundary(string);
            HttpEntity entity = builder.build();
            httpPost.setHeader("Connection", "Keep-Alive");
            httpPost.setHeader("Accept-Encoding", "gzip");
            httpPost.setHeader("referer", "https://servicewechat.com/wx2fd91fc20b4d1376/6/page-frame.html");
            httpPost.setHeader("token", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI1YjNjYTI4Mi1hMjk0LTQzMTUtOTI2Mi1jMTM3YjQwY2MwNDAiLCJpYXQiOjE1NTYyNjg5MDEsImlzcyI6ImRlbW8iLCJzdWIiOiJ7XCJjZWxscGhvbmVcIjpcIlwiLFwiZW1haWxcIjpcIlwiLFwibmlja05hbWVcIjpcIktpbmdcIixcIm9wZW5pZFwiOlwib3ZVNFo0MXRIOVphalRMNnhfWHpJOVIxRldwVVwiLFwidXNlcklkXCI6MTAwMDAwMDAwMDMzOTgsXCJ1c2VyTmFtZVwiOlwiXCIsXCJ1c2VyUGhvdG9VUkxcIjpcImh0dHBzOi8vd3gucWxvZ28uY24vbW1vcGVuL3ZpXzMyL0RZQUlPZ3E4M2VyMnk3c2NZVXlxNExvbTNEUmdGWlk4eEFQM0lYclFBaWNta28wTElPWHd3MlE5U2RPZG9oVFB4M052ZTNrc3E5RU9Ob1NpYU5DUmFVNFEvMTMyXCIsXCJ1c2VyVHlwZVwiOlwiM1wifSJ9.8A-971_kcV0aXCJ7pjHpuh0xyp-hQbuIbfJ0Ch9J9pk");
            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Linux; Android 7.0; SM-G9350 Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/64.0.3282.137 Mobile Safari/537.36 MicroMessenger/6.7.3.1360(0x26070333) NetType/WIFI Language/zh_CN Process/appbrand0");
            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=" + string);
            httpPost.setHeader("Host", "mallwx.ltg.cn");
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);// 执行提交
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                // 将响应内容转换为字符串
                result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
                System.out.println(result);
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
        return result;
    }
}
