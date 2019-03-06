package com.tourist.module.brushticket.dao;

import com.tourist.module.brushticket.entity.SuccessOrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author chenx 2019-02-21 18:06
 */
public interface SuccessOrderInfoDao extends JpaRepository<SuccessOrderInfo, Integer> {

    @Modifying
    @Query(value = "update success_order_info set status='success' where id = ?1 ",nativeQuery = true)
    void changeStatus(Integer id);
}
