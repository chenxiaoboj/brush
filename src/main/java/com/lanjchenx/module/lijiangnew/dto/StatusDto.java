package com.lanjchenx.module.lijiangnew.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author admin 2019-12-21 17:54
 */
@ApiModel(value = "状态查询参数")
public class StatusDto {

    @ApiModelProperty(value = "照片状态 0：未上传, 1:已上传",example="1")
    private Integer imgStatus;
    @ApiModelProperty(value = "生成参数状态 0：否 1：是",example="1")
    private Integer paraStatus;
    @ApiModelProperty(value = "联系人上传状态 0：否 1：是",example="1")
    private Integer peopleStatus;
    @ApiModelProperty(value = "分组状态",example="1")
    private Integer groupStatus;
    @ApiModelProperty(value = "用户id",example="1")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getImgStatus() {
        return imgStatus;
    }

    public void setImgStatus(Integer imgStatus) {
        this.imgStatus = imgStatus;
    }

    public Integer getParaStatus() {
        return paraStatus;
    }

    public void setParaStatus(Integer paraStatus) {
        this.paraStatus = paraStatus;
    }

    public Integer getPeopleStatus() {
        return peopleStatus;
    }

    public void setPeopleStatus(Integer peopleStatus) {
        this.peopleStatus = peopleStatus;
    }

    public Integer getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(Integer groupStatus) {
        this.groupStatus = groupStatus;
    }
}
