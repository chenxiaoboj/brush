package com.tourist.module.lijiangnew.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author admin 2019-05-01 15:22
 * 账户信息表
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONE)
public class LijiangAccountNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String phone;
    private String password;
    private Integer delFlag;

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
