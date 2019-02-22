package com.tourist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author chenx
 * @author chenx
 */
@SpringBootApplication
@EnableScheduling
public class TouristApplication {

    public static void main(String[] args) {
        SpringApplication.run(TouristApplication.class, args);
    }

}


