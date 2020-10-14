package com.lanjchenx.module.lijiangnew.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
import javax.persistence.*;
import java.util.Date;

/**
 * @author chenxiaobo 2020-07-15 9:50
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONE)
public class LijiangTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * 时间
     */
    private String time;
    /**
     * 状态
     */
    private Integer  delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
