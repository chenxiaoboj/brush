package com.tourist.module.brushticket.dao;

import com.tourist.module.brushticket.entity.BrushTicketInfo;
import com.tourist.module.brushticket.entity.TouristInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author chenx 2019-02-21 16:36
 */
public interface TouristInfoDao extends JpaRepository<TouristInfo, Integer> {

    @Query(value = "select * from tourist_info GROUP BY remarks", nativeQuery = true)
    List<TouristInfo> getRemarks();

    @Query(value = "SELECT remarks from tourist_info GROUP BY remarks",nativeQuery = true)
    List<String> getFenzu();

    List<TouristInfo> findAllByRemarks(String remarks);
}
