package com.tourist.module.utils;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author admin 2019-02-23 20:27
 */
public class IpUtil {
    public static boolean checkIp(String hostName, Integer port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(hostName, port));
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(LocalDateTime.now() + "--------fail");
            return false;
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        for (int j = 0; j < 20; j++) {
            System.out.println( i.getAndIncrement());
        }
    }

}
