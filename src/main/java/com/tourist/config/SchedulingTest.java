package com.tourist.config;

import com.tourist.module.lijiangnew.dao.LijiangValidateInfoDao;
import com.tourist.module.lijiangnew.service.LijiangNewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 定时任务配置类
 *
 * @author chenx
 */
@Component
public class SchedulingTest {

    @Resource
    private LijiangNewService lijiangNewService;
    @Resource
    private LijiangValidateInfoDao lijiangValidateInfoDao;

    private Logger logger = LoggerFactory.getLogger(SchedulingTest.class);

    /**
     * 每天7点执行
     */
    @Scheduled(cron = "1 0 7 * * ?")
    @Async
    public void schedulerBrush() {
        logger.info("<<<<<<<<<<<<<---------------刷票任务启动---------------->>>>>>>>>>>>>>>>>>>");
        lijiangNewService.brushOrd();
    }

    /**
     * 每天5点执行，清空多余验证码
     */
    @Scheduled(cron = "0 0 5 * * ?")
    @Async
    @Transactional
    public void deleteValue() {
        logger.info("<<<<<<<<<<<<<---------------清空验证码---------------->>>>>>>>>>>>>>>>>>>");
        lijiangValidateInfoDao.deleteAll();
    }
}