package com.tourist.module.lijiangnew.dao;

import com.tourist.module.lijiangnew.entity.LijiangAccountNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author admin 2019-05-01 15:27
 */
public interface AccountNumberDao extends JpaRepository<LijiangAccountNumber, Integer> {

    @Query(value = "select * from lijiang_account_number limit ?1,?2", nativeQuery = true)
    List<LijiangAccountNumber> getAccountNumber(Integer beginSize,Integer endSize);

    List<LijiangAccountNumber> findByDelFlag(Integer delFlag);
}
