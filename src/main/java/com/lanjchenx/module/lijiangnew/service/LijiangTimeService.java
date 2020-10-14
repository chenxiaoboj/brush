package com.lanjchenx.module.lijiangnew.service;

import com.lanjchenx.dto.ApiResult;
import com.lanjchenx.dto.ApiReturn;
import com.lanjchenx.module.lijiangnew.entity.LijiangTime;

import java.util.Date;

/**
 * @author chenxiaobo 2020-07-15 9:56
 */
public interface LijiangTimeService {

    ApiReturn setTime(String time);

    ApiResult<LijiangTime> getTime();

}
