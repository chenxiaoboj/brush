package com.lanjchenx.module.lijiangnew.dao;

import com.lanjchenx.modole.repository.CustomRepository;
import com.lanjchenx.module.lijiangnew.entity.LijiangAccountNumber;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author admin 2019-05-01 15:27
 */
public interface AccountNumberDao extends CustomRepository<LijiangAccountNumber, Integer> {

    @Query(value = "select * from lijiang_account_number limit ?1,?2", nativeQuery = true)
    List<LijiangAccountNumber> getAccountNumber(Integer beginSize, Integer endSize);

    List<LijiangAccountNumber> findByDelFlag(Integer delFlag);

    @Query(value = "select * from lijiang_account_number where del_flag=1 and login_status = 1 and use_status=0 limit 0,?1", nativeQuery = true)
    List<LijiangAccountNumber> findSize(Integer size);

    List<LijiangAccountNumber> findByDelFlagAndLoginStatusAndUseStatus(Integer delFlag, Integer loginStatus, Integer useStatus);

}
