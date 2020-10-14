package com.lanjchenx.module.lijiangnew.dao;

import com.lanjchenx.modole.repository.CustomRepository;
import com.lanjchenx.module.lijiangnew.entity.LijiangValidateInfo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author admin 2019-05-19 15:55
 */
public interface LijiangValidateInfoDao extends CustomRepository<LijiangValidateInfo, Integer> {

    @Query(value = "select * from lijiang_validate_info where value_date>?1 order by value_date DESC limit 0,?2 ", nativeQuery = true)
    List<LijiangValidateInfo> findSize(String time,Integer size);

    @Query(value = "select validate from lijiang_validate_info where del_flag=0 order by value_date DESC limit 0,1 ", nativeQuery = true)
    String getOneValidate();

}
