package com.tourist.module.lijiangnew.component;

/**
 * @author chenx 2019-06-12 15:49
 */

import com.google.common.collect.Maps;
import com.tourist.module.lijiangnew.entity.LijiangParameterInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledExecutor {
    private ScheduledExecutorService scheduExec;

    public long start;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledExecutor.class);
    @Resource
    private LijiangComp lijiangComp;

    public ScheduledExecutor() {
        this.scheduExec = Executors.newScheduledThreadPool(2);
        this.start = System.currentTimeMillis();
    }

    public void createOrder(Long initialDelay, Map<String, LijiangParameterInfo> map1, Map<String, LijiangParameterInfo> map2) {
        scheduExec.schedule(new Runnable() {
            public void run() {
                logger.info("<<<<<<<<<<<<<<<<<<<<<<-------------执行下单任务-------------->>>>>>>>>>>>>>>>>>>>>>>>>>>");
                map1.forEach((key, value) -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lijiangComp.saveOrder(value.getToken(), value.getParameters(), value.getId());
                });
                logger.info("执行第一组---------:" + LocalDateTime.now());
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("执行第二组:--------" + LocalDateTime.now());
                map2.forEach((key, value) -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lijiangComp.saveOrder(value.getToken(), value.getParameters(), value.getId());
                });
            }
        }, initialDelay, TimeUnit.MILLISECONDS);
    }
}