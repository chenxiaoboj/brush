package com.tourist.module.utils;

import org.apache.commons.lang3.RandomUtils;

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
}
