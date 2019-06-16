package com.tourist.module.lijiangnew.dao;

import com.tourist.module.lijiangnew.entity.LijiangValidateInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author admin 2019-05-19 15:55
 */
public interface LijiangValidateInfoDao extends JpaRepository<LijiangValidateInfo, Integer> {

    @Query(value = "select * from lijiang_validate_info where value_date>?1 order by value_date limit 0,?2 ", nativeQuery = true)
    List<LijiangValidateInfo> findSize(String time,Integer size);
}
