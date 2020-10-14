package com.lanjchenx.config;

import com.lanjchenx.module.lijiangnew.dao.LijiangParameterInfoDao;
import com.lanjchenx.module.lijiangnew.dao.LijiangTouristDao;
import com.lanjchenx.module.lijiangnew.dao.LijiangValidateInfoDao;
import com.lanjchenx.module.lijiangnew.service.LijiangNewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 定时任务配置类
 *
 * @author chenx
 */
@Component
public class SchedulingTest {

    @Autowired
    private LijiangNewService lijiangNewService;

    @Autowired
    private LijiangValidateInfoDao lijiangValidateInfoDao;

    @Autowired
    private LijiangTouristDao lijiangTouristDao;
    @Autowired
    private LijiangParameterInfoDao lijiangParameterInfoDao;

    private Logger logger = LoggerFactory.getLogger(SchedulingTest.class);

    /**
     * 每天8点执行
     */
    @Scheduled(cron = "0 0 7 * * ?")
    @Async
    public void schedulerBrush() {
        logger.info("<<<<<<<<<<<<<---------------刷票任务启动---------------->>>>>>>>>>>>>>>>>>>");
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lijiangNewService.brushOrd();
    }

    /**
     * 每天5点执行，清空多余验证码
     */
    @Scheduled(cron = "0 0 5 * * ?")
    @Async
    @Transactional
    public void deleteValue() {
        logger.info("<<<<<<<<<<<<<---------------清空验证码,标记联系人---------------->>>>>>>>>>>>>>>>>>>");
        lijiangTouristDao.updateNewFlag();
        lijiangValidateInfoDao.deleteAll();
    }

    /**
     * 每天5点执行，清空参数表
     */
    @Scheduled(cron = "0 0 20 * * ?")
    @Async
    @Transactional
    public void deleteParameter() {
        logger.info("<<<<<<<<<<<<<---------------清空参数表---------------->>>>>>>>>>>>>>>>>>>");
        lijiangParameterInfoDao.deleteAll();
    }
}