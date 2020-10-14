package com.lanjchenx.module.lijiangnew.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author admin 2019-12-26 11:48
 */
@ApiModel(value = "参数列表返回数据")
public class ParameterDto {

    @ApiModelProperty(value = "抢票状态")
    private String status;
    @ApiModelProperty(value = "返回信息")
    private String message;
    @ApiModelProperty(value = "姓名")
    private String names;
    @ApiModelProperty(value = "下单手机号")
    private String phone;
    @ApiModelProperty(value = "账号")
    private String userName;
    @ApiModelProperty(value = "证件类型")
    private String cardName;
    @ApiModelProperty(value = "人数",example="1")
    private Integer countNumber;
    @ApiModelProperty(value = "id",example="1")
    private Integer id;
    @ApiModelProperty(value = "订单号")
    private String orderBatchNo;
    @ApiModelProperty(value = "订单二维码链接")
    private String orderUrl;

    public ParameterDto() {
    }

    public ParameterDto(String status, String message, String names, String phone,
                        String userName, Integer countNumber, String cardName,Integer id, String orderBatchNo, String orderUrl) {
        this.status = status;
        this.message = message;
        this.names = names;
        this.phone = phone;
        this.userName = userName;
        this.cardName = cardName;
        this.countNumber = countNumber;
        this.id = id;
        this.orderBatchNo = orderBatchNo;
        this.orderUrl = orderUrl;
    }

    public String getOrderBatchNo() {
        return orderBatchNo;
    }

    public void setOrderBatchNo(String orderBatchNo) {
        this.orderBatchNo = orderBatchNo;
    }

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCountNumber() {
        return countNumber;
    }

    public void setCountNumber(Integer countNumber) {
        this.countNumber = countNumber;
    }
}
