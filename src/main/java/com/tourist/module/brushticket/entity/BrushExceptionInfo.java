package com.tourist.module.brushticket.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author chenx 2019-02-20 18:39
 */
@Entity
public class BrushExceptionInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 异常信息
     */
    @Column(length = 500)
    private String message;
    /**
     * 异常的cookie
     */
    @Column(length = 500)
    private String cookie;
    /**
     * 异常步骤(1:验证码 2：下订单 3：获取支付验证码)
     */
    private Integer count;

    /**
     * 获取支付二维码的url
     */
    private String getEwmUrl;
    /**
     * 订单id
     */
    private String authOrdersId;
    /**
     * 订单参数
     */
    @Column(length = 1000)
    private String parameter;

    /**
     * 人数
     */
    private Integer number;
    /**
     * 手机号
     */
    private String mobile;
    private String delFlag;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getAuthOrdersId() {
        return authOrdersId;
    }

    public void setAuthOrdersId(String authOrdersId) {
        this.authOrdersId = authOrdersId;
    }

    public String getGetEwmUrl() {
        return getEwmUrl;
    }

    public void setGetEwmUrl(String getEwmUrl) {
        this.getEwmUrl = getEwmUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
