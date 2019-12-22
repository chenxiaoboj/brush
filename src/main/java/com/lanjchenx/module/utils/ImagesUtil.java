//package com.lanjchenx.module.utils;
//
//import org.springframework.web.multipart.MultipartFile;
//import sun.misc.BASE64Encoder;
//
///**
// * @author admin 2019-05-01 14:08
// */
//public class ImagesUtil {
//
//    public static String test(MultipartFile file) throws Exception {
//        BASE64Encoder base64Encoder = new BASE64Encoder();
//        String base64EncoderImg = file.getOriginalFilename() + "," + base64Encoder.encode(file.getBytes());
//        return base64EncoderImg;
//    }
//
//}
