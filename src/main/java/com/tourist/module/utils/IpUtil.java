package com.tourist.module.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

/**
 * @author admin 2019-02-23 20:27
 */
public class IpUtil {
    public boolean checkIp() {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("101.205.55.214", 1658));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("fail");
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
