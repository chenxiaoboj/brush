package com.lanjchenx.module.lijiangnew.service.impl;

import com.lanjchenx.constants.CommonConstants;
import com.lanjchenx.dto.ApiResult;
import com.lanjchenx.dto.ApiReturn;
import com.lanjchenx.errorcode.ErrorCode;
import com.lanjchenx.module.lijiangnew.dao.LijiangTimeDao;
import com.lanjchenx.module.lijiangnew.entity.LijiangTime;
import com.lanjchenx.module.lijiangnew.service.LijiangTimeService;
import com.lanjchenx.utils.DateStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chenxiaobo 2020-07-15 9:58
 */
@Service
public class LijiangTimeServiceImpl implements LijiangTimeService {

    private Logger logger = LoggerFactory.getLogger(LijiangTimeServiceImpl.class);
    @Resource
    private LijiangTimeDao lijiangTimeDao;

    @Override
    public ApiReturn setTime(String time) {
        try {
            String[] strings = time.split("-");
            if (Integer.parseInt(strings[0]) < 2020 || Integer.parseInt(strings[1]) < 0
                    || Integer.parseInt(strings[1]) > 12 || Integer.parseInt(strings[2]) < 0
                    || Integer.parseInt(strings[2]) > 31) {
                logger.info("传入订票时间为:{}",time);
                return ApiReturn.failure("时间格式不正确");
            }
        } catch (Exception e) {
//            e.printStackTrace();
            logger.info("类型转换异常:{}",time);
            return ApiReturn.failure("时间格式不正确");
        }
        LijiangTime lijiangTime = lijiangTimeDao.findFirstByDelFlag(0);
        if (lijiangTime == null) {
            return ApiReturn.failure("时间不存在");
        }
        lijiangTime.setTime(time);
        lijiangTimeDao.save(lijiangTime);
        return ApiReturn.success("修改成功");
    }

    @Override
    public ApiResult<LijiangTime> getTime() {
        LijiangTime lijiangTime = lijiangTimeDao.findFirstByDelFlag(0);
        return new ApiResult(ErrorCode.SUCCESS, "获取成功", lijiangTime);
    }
}
