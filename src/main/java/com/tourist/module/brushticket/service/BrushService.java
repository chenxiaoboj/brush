package com.tourist.module.brushticket.service;

import com.tourist.module.brushticket.entity.SuccessOrderInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author chenx 2019-02-22 16:09
 */
public interface BrushService {
    /**
     * 开始刷票
     *
     * @param goodId
     * @return
     */
    String brush(String goodId, Double coefficient,String ipUrl);

    /**
     * 抓取代理ip库
     *
     * @return
     */
    String getIps(Integer count);

    /**
     * 检验ip
     *
     * @return
     */
    String checkIp();

    /**
     * 测试异步
     */
    void testThread();
    /**
     * 测试异步
     */
    List<SuccessOrderInfo> getEwmList();
}
