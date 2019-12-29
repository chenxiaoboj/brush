package com.lanjchenx.module.utils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author admin 2019-05-01 14:08
 */
public class ImagesUtil {

    public static void main(String[] args) {
        String imageBase64 = "";
        String path = "xxxxxxx";//图片url
        try {
            imageBase64 = getImageByPath(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(imageBase64);
        //TODO 做自己的业务
    }

    public static String getImageByPath(String path) throws IOException {
        URL url = null;
        HttpURLConnection httpUrl = null;
        InputStream in = null;
        byte[] data = null;
        try {
            url = new URL(path);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            in = httpUrl.getInputStream();
            data = new byte[in.available()];
            in.read(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null)
                in.close();
        }
        return data == null ? "" : Base64.encodeBase64String(data);
    }

}
