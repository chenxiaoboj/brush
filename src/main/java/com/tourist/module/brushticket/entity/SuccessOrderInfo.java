package com.tourist.module.brushticket.entity;

import javax.persistence.*;

/**
 * @author chenx 2019-02-21 17:55
 */
@Entity
public class SuccessOrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
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
}
