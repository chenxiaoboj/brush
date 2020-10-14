package com.lanjchenx.module.lijiangnew.dao;

import com.lanjchenx.modole.repository.CustomRepository;
import com.lanjchenx.module.lijiangnew.entity.LijiangTime;

/**
 * @author chenxiaobo 2020-07-15 10:00
 */
public interface LijiangTimeDao extends CustomRepository<LijiangTime, Integer> {

    LijiangTime findFirstByDelFlag(Integer delFlag);
}
