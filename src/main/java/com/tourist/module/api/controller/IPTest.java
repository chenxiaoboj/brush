package com.tourist.module.api.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @author chenx 2019-02-22 16:42
 */
public class IPTest {
    public static void main(String[] args) throws IOException {

        String s = "[goods_id=1846446, pintuan_id=, play_date=2019-03-03, time_slot_damoylxs[]=100000141762|100000000014|17:00:00-17:59:59|600, amount=5, g_batch_type=2, name=邓碧莹, mobile=13013314007, id_number=452623199710193323, id_number_list[]=452623199806153326, player_name_list[]=陆玉萍, player_mobile_list[]=13013314007, id_number_list[]=372928199804280012, player_name_list[]=武致远, player_mobile_list[]=13013314007, id_number_list[]=511011199308256266, player_name_list[]=李何丽, player_mobile_list[]=13013314007, id_number_list[]=511002199708251249, player_name_list[]=黎议瞳, player_mobile_list[]=13013314007]";
        s.replace("18","28");
        String[] strings = s.split(",");
        System.out.println(strings);
    }
}
