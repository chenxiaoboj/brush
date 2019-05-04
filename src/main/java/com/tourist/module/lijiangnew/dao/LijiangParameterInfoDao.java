package com.tourist.module.lijiangnew.dao;

import com.tourist.module.lijiangnew.entity.LijiangParameterInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author chenx 2019-02-21 16:36
 */
public interface LijiangParameterInfoDao extends JpaRepository<LijiangParameterInfo, Integer> {

    List<LijiangParameterInfo> findByDelFlagAndUsername(Integer delFlag, String userName);

    List<LijiangParameterInfo> findByDelFlag(Integer delFlag);

}
