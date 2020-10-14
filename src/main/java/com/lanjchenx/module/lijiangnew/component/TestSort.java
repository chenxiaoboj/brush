package com.lanjchenx.module.lijiangnew.component;

import java.util.*;

/**
 * @author chenxiaobo 2020-03-23 22:05
 */
public class TestSort {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();
        map.put("1", 8);
        map.put("2", 53);
        map.put("3", 53);
        map.put("4", 53);
        map.put("5", 11);
        map.put("6", 3);
        map.put("7", 3);
        List<Map.Entry<String,Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (o2, o1) -> (o1.getValue() - o2.getValue()));
        System.out.println(list.get(0));
    }
}
