package com.tourist.module.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;
import java.util.Set;

/**
 * @author admin 2019-05-19 16:45
 */
public class RandomUtil {

    public static String getRandomString(Integer size) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(RandomUtils.nextInt(0, 9));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Set<String> set = Sets.newHashSet();
        for (int i = 0; i < 10000; i++) {
            Integer k = RandomUtils.nextInt(1, 100);
            Integer j = RandomUtils.nextInt(1, 100);
            if (RandomUtils.nextInt(0, 2) == 0) {
                if (k < j) {
                    set.add(j + "-" + k);
                } else {
                    set.add(k + "-" + j);
                }
            } else {
                set.add(k + "+" + j);
            }
            if (set.size() == 1000) {
                set.forEach(string -> {
                    System.out.println(string);
                });
                return;
            }
        }
    }
}
