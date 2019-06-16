package com.tourist.module.lijiangnew.dao;

import com.tourist.module.lijiangnew.entity.LijiangTouristInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author chenx 2019-02-21 16:36
 */
public interface LijiangTouristDao extends JpaRepository<LijiangTouristInfo, Integer> {

    LijiangTouristInfo findFirstByCertificateNo(String idNumber);

    List<LijiangTouristInfo> findAllByCertificateName(String name);

    List<LijiangTouristInfo> findByDelFlag(Integer delFlag);

    List<LijiangTouristInfo> findByUserIdAndDelFlag(Integer userId,Integer delFlag);


}
