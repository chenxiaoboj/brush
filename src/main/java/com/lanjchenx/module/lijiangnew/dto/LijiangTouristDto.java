package com.lanjchenx.module.lijiangnew.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * @author admin 2019-12-21 18:59
 */
@ApiModel(value = "游客信息返回数据")
public class LijiangTouristDto {

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
     * 上传标记
     */
    private String delFlag;
    /**
     * 生成参数标识
     */
    private String parameter;
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
    private String imgStatus;
    /**
     * 新数据  1:成功 0 :失败
     */
    private String newFlag;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cdate;

    public LijiangTouristDto() {
    }

    public LijiangTouristDto(Integer id, String certificateNo, String certificateCardName,
                             String certificateName, int certificateTypeId, String phoneNumber,
                             String facePicPath, String delFlag, String parameter, Integer userId,
                             Integer accountNumberId, String userGroup, String imgStatus, String newFlag, Date cdate) {
        this.id = id;
        this.certificateNo = certificateNo;
        this.certificateCardName = certificateCardName;
        this.certificateName = certificateName;
        this.certificateTypeId = certificateTypeId;
        this.phoneNumber = phoneNumber;
        this.facePicPath = facePicPath;
        this.delFlag = delFlag;
        this.parameter = parameter;
        this.userId = userId;
        this.accountNumberId = accountNumberId;
        this.userGroup = userGroup;
        this.imgStatus = imgStatus;
        this.newFlag = newFlag;
        this.cdate = cdate;
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


    public Integer getAccountNumberId() {
        return accountNumberId;
    }

    public void setAccountNumberId(Integer accountNumberId) {
        this.accountNumberId = accountNumberId;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getImgStatus() {
        return imgStatus;
    }

    public void setImgStatus(String imgStatus) {
        this.imgStatus = imgStatus;
    }

    public String getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(String newFlag) {
        this.newFlag = newFlag;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }
}
