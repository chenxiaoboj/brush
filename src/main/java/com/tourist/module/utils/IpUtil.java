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
		/*
		 题目: 将颜色数组 红色,绿色,蓝色 转成 JSON 字符串
		 */
		String string = "[goods_id=1843845, pintuan_id=, play_date=2019-03-07, time_slot_damoylxs[]=100000128991|100000000013|11:00:00-11:29:59|90, amount=5, g_batch_type=2, name=刘晴, mobile=15306099325, id_number=520111198710050428, id_number_list[]=362322198607203918, player_name_list[]=蔡恩平, player_mobile_list[]=15306099325, id_number_list[]=132235198005142349, player_name_list[]=孙丽萍, player_mobile_list[]=15306099325, id_number_list[]=130281199208231713, player_name_list[]=方伟, player_mobile_list[]=15306099325, id_number_list[]=522123199811230032, player_name_list[]=范航航  , player_mobile_list[]=15306099325]";
        String s = string.replace(" ", "");
		String[] colors = s.substring(1,s.length()-1).split(",");
        // JSONArray 存入 colors
        try {
            JSONArray jsonArray = new JSONArray(Arrays.asList(colors));
            System.out.println(jsonArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
