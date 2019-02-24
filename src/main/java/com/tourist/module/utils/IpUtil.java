package com.tourist.module.utils;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.net.Socket;

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
            System.out.println("fail");
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
}
