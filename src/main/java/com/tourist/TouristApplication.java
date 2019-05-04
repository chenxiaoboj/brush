package com.tourist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.servlet.MultipartConfigElement;

/**
 * @author chenx
 * @author chenx
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class TouristApplication {

    public static void main(String[] args) {
        SpringApplication.run(TouristApplication.class, args);
    }
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //  单个数据大小
        factory.setMaxFileSize("1024KB");
        /// 总上传数据大小
        factory.setMaxRequestSize("1024KB");
        return factory.createMultipartConfig();
    }
}


