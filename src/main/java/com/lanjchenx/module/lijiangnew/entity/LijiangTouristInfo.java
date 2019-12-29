package com.lanjchenx.module.lijiangnew.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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
     * 返回信息
     */
    private String message;
    /**
     * 图片地址
     */
    private String facePicPath;
    /**
     * 上传标记
     */
    private Integer delFlag;
    /**
     * 生成参数标识
     */
    private Integer parameter;
    /**
     * userID
     */
    private Integer userId;
    /**
     * 使用账号id
     */
    private Integer accountNumberId;
    /**
     * 用户分组标识
     */
    private String userGroup;
    /**
     * 照片上传状态  1:成功 0 :失败
     */
    private Integer imgStatus;
    /**
     * 新数据  1:成功 0 :失败
     */
    private Integer newFlag;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cdate;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(Integer newFlag) {
        this.newFlag = newFlag;
    }

    public Integer getParameter() {
        return parameter;
    }

    public void setParameter(Integer parameter) {
        this.parameter = parameter;
    }

    public Integer getAccountNumberId() {
        return accountNumberId;
    }

    public void setAccountNumberId(Integer accountNumberId) {
        this.accountNumberId = accountNumberId;
    }

    public Integer getImgStatus() {
        return imgStatus;
    }

    public void setImgStatus(Integer imgStatus) {
        this.imgStatus = imgStatus;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

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
