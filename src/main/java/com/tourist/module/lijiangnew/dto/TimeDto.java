package com.tourist.module.lijiangnew.dto;

/**
 * @author admin 2019-05-02 0:49
 */
public class TimeDto {

    /**
     * businessOrgId : 1
     * timeControlType : XSSKKC
     * controlDate : 2019-05-02
     * scenicSpotsId : 10000000000002
     */

    private String businessOrgId;
    private String timeControlType;
    private String controlDate;
    private String scenicSpotsId;
    private String orderNetType;

    public String getBusinessOrgId() {
        return businessOrgId;
    }

    public void setBusinessOrgId(String businessOrgId) {
        this.businessOrgId = businessOrgId;
    }

    public String getTimeControlType() {
        return timeControlType;
    }

    public void setTimeControlType(String timeControlType) {
        this.timeControlType = timeControlType;
    }

    public String getControlDate() {
        return controlDate;
    }

    public void setControlDate(String controlDate) {
        this.controlDate = controlDate;
    }

    public String getScenicSpotsId() {
        return scenicSpotsId;
    }

    public void setScenicSpotsId(String scenicSpotsId) {
        this.scenicSpotsId = scenicSpotsId;
    }

    public String getOrderNetType() {
        return orderNetType;
    }

    public void setOrderNetType(String orderNetType) {
        this.orderNetType = orderNetType;
    }

    public TimeDto(String businessOrgId, String timeControlType, String controlDate, String scenicSpotsId, String orderNetType) {
        this.businessOrgId = businessOrgId;
        this.timeControlType = timeControlType;
        this.controlDate = controlDate;
        this.scenicSpotsId = scenicSpotsId;
        this.orderNetType = orderNetType;
    }
}
