package com.tourist.module.brushticket.service;

import java.math.BigDecimal;

/**
 * @author chenx 2019-02-22 16:09
 */
public interface BrushService {
    /**
     * 开始刷票
     * @param goodId
     * @return
     */
    String brush(String goodId, Double coefficient);

    /**
     * 抓取代理ip库
     * @return
     */
    String getIps(Integer count);
}
