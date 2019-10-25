package com.tourist.module.lijiangnew.dao;

import com.tourist.module.lijiangnew.entity.LijiangTokenInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author chenx 2019-02-21 16:36
 */
public interface LijiangTokenInfoDao extends JpaRepository<LijiangTokenInfo, Integer> {

    List<LijiangTokenInfo>  findByDelFlag(Integer delFlag);
}
