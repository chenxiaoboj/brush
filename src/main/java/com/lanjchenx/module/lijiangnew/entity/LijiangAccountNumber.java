package com.lanjchenx.module.lijiangnew.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

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
    @Column(length = 800)
    private String token;
    private Integer delFlag;
    //登录状态 0：未登陆 1：已登陆
    private Integer loginStatus;
    //使用状态 0：未使用 1：已使用
    private Integer useStatus;
    //上传照片使用的账号标记
    private Integer imgFlag;

    public Integer getImgFlag() {
        return imgFlag;
    }

    public void setImgFlag(Integer imgFlag) {
        this.imgFlag = imgFlag;
    }

    public Integer getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }

    public Integer getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Integer loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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
