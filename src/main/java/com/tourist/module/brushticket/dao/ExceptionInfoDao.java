package com.tourist.module.brushticket.dao;

import com.tourist.module.brushticket.entity.BrushExceptionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author chenx 2019-02-21 16:36
 */
public interface ExceptionInfoDao extends JpaRepository<BrushExceptionInfo,Integer> {
    List<BrushExceptionInfo> findAllByCountAndDelFlagOrderByCreateTimeDesc(Integer count,String delFlag);

    List<BrushExceptionInfo> findAllByCountAndDelFlag(Integer count,String delFlag);

}
