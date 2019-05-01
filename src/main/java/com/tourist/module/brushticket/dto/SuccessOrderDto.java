package com.tourist.module.brushticket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author admin 2019-03-06 21:54
 */
@ApiModel(value = "成功订单列表")
public class SuccessOrderDto {

    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty(value = "支付二维码地址")
    private String ewmUrl;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "人数")
    private Integer number;
    @ApiModelProperty(value = "获取单号url")
    private String  orderIdUrl;
    @ApiModelProperty(value = "支付状态")
    private String  status;




}
