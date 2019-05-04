package com.tourist.module.lijiangnew.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author admin 2019-05-01 20:47
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONE)
public class LijiangTouristInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * 身份证号
     */
    private String certificateNo;
    /**
     * 证件类型（身份证）
     */
    private String certificateCardName;
    /**
     * 姓名
     */
    private String certificateName;
    /**
     * "certificateTypeId": 1,
     */
    private int certificateTypeId;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 图片地址
     */
    private String facePicPath;
    /**
     * 标记
     */
    private Integer delFlag;
    /**
     * userID
     */
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getCertificateCardName() {
        return certificateCardName;
    }

    public void setCertificateCardName(String certificateCardName) {
        this.certificateCardName = certificateCardName;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public int getCertificateTypeId() {
        return certificateTypeId;
    }

    public void setCertificateTypeId(int certificateTypeId) {
        this.certificateTypeId = certificateTypeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFacePicPath() {
        return facePicPath;
    }

    public void setFacePicPath(String facePicPath) {
        this.facePicPath = facePicPath;
    }
}
