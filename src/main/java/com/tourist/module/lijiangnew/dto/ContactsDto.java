package com.tourist.module.lijiangnew.dto;

/**
 * @author admin 2019-05-01 19:00
 */
public class ContactsDto {


    /**
     * certificateTypeId : 1
     * frequentContactsPhone : 13769036460
     * photoUrl : https://mallinter.ltg.cn:28866/group1/M00/02/C2/rBDUslzJqI6AeucPAALc05p6f0Q69..jpg
     * certificateNo : 142227199403232012
     * frequentContactsName : 王利文
     */

    private String certificateTypeId;
    private String frequentContactsPhone;
    private String photoUrl;
    private String certificateNo;
    private String frequentContactsName;
    private String validate;

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public String getCertificateTypeId() {
        return certificateTypeId;
    }

    public void setCertificateTypeId(String certificateTypeId) {
        this.certificateTypeId = certificateTypeId;
    }

    public String getFrequentContactsPhone() {
        return frequentContactsPhone;
    }

    public void setFrequentContactsPhone(String frequentContactsPhone) {
        this.frequentContactsPhone = frequentContactsPhone;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getFrequentContactsName() {
        return frequentContactsName;
    }

    public void setFrequentContactsName(String frequentContactsName) {
        this.frequentContactsName = frequentContactsName;
    }

    public ContactsDto(String certificateTypeId, String frequentContactsPhone, String photoUrl, String certificateNo, String frequentContactsName, String validate) {
        this.certificateTypeId = certificateTypeId;
        this.frequentContactsPhone = frequentContactsPhone;
        this.photoUrl = photoUrl;
        this.certificateNo = certificateNo;
        this.frequentContactsName = frequentContactsName;
        this.validate = validate;
    }
}
