package com.lanjchenx.module.lijiangnew.entity;


import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.util.Date;

/**
 * @author admin 2019-05-01 21:27
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONE)
public class LijiangParameterInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * 完整参数
     */
    @Column(length = 5000)
    private String parameters;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户名
     */
    private Date createTime;
    /**
     * 用户名
     */
    private String phone;
    /**
     * 密码
     */
    private String password;
    /**
     * 人数
     */
    private Integer countNumber;
    /**
     * token
     */
    @Column(length = 800)
    private String token;
    /**
     * 标记(0：未抢票或抢票失败，1：下单成功)
     */
    private Integer delFlag;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(Integer countNumber) {
        this.countNumber = countNumber;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
