package com.lanjchenx.module.lijiangnew.dao;

import com.lanjchenx.modole.repository.CustomRepository;
import com.lanjchenx.module.lijiangnew.entity.LijiangTokenInfo;

import java.util.List;

/**
 * @author chenx 2019-02-21 16:36
 */
public interface LijiangTokenInfoDao extends CustomRepository<LijiangTokenInfo, Integer> {

    List<LijiangTokenInfo>  findByDelFlag(Integer delFlag);
}
