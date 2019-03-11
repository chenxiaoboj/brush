package com.tourist.module.brushticket.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author chenx 2019-02-21 17:55
 */
@Entity
public class SuccessOrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 支付二维码地址
     */
    private String ewmUrl;
    /**
     * 请求参数
     */
    @Column(length = 1000)
    private String parameter;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 手机号
     */
    private Integer number;
    /**
     * 获取单号url
     */
    private String  orderIdUrl;
    /**
     * 支付状态
     */
    private String  status;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEwmUrl() {
        return ewmUrl;
    }

    public void setEwmUrl(String ewmUrl) {
        this.ewmUrl = ewmUrl;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getOrderIdUrl() {
        return orderIdUrl;
    }

    public void setOrderIdUrl(String orderIdUrl) {
        this.orderIdUrl = orderIdUrl;
    }
}
