package com.tourist.module.brushticket.dao;

import com.tourist.module.brushticket.entity.BrushTicketInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author chenx 2019-02-21 18:06
 */
public interface BrushTicketInfoDao extends JpaRepository<BrushTicketInfo, Integer> {

    List<BrushTicketInfo> findAllByDelFlag(String delFalg);

}
