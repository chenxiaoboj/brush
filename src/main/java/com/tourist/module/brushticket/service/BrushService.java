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
    String brush(String goodId, Double coefficient, String ipUrl);

    /**
     * 测试是否可以刷票
     */
    String testOk(String ipUrl);

    /**
     * 处理异常数据
     */
    String disposeException();

    /**
     * 更改支付状态
     */
    String changeStatus(Integer id);

    /**
     * 测试异步
     */
    void testThread();

    /**
     * 测试异步
     */
    List<SuccessOrderInfo> getEwmList();


}
