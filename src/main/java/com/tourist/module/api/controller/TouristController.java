package com.tourist.module.api.controller;

import com.tourist.module.brushticket.service.BrushService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author chenx 2019-02-22 16:34
 */
@Api(value = "TouristController", tags = "")
@RestController
@RequestMapping(value = "api/v1/tourist")
public class TouristController {

    @Resource
    private BrushService brushService;

    @ApiOperation(value = "开始刷票")
    @GetMapping(value = "/brush")
    public String brush(@RequestParam String goodId, @RequestParam Double coefficient, @RequestParam String ipUrl) {
        return brushService.brush(goodId, coefficient, ipUrl);
    }

    @ApiOperation(value = "获取订单列表（支付二维码）地址列表")
    @GetMapping(value = "/getOrderList")
    public String getEwmUrl(@RequestParam String goodId, @RequestParam Double coefficient) {
        return null;
    }

    @ApiOperation(value = "处理状态为3的异常数据接口（支付二维码地址）")
    @GetMapping(value = "/disposeException")
    public String disposeException() {
        return brushService.disposeException();
    }
    @ApiOperation(value = "处理状态为其他的异常数据接口（i/o异常）")
    @GetMapping(value = "/disposeExceptionIO")
    public String disposeException(@RequestParam String goodId) {
        return brushService.disposeException();
    }

    @ApiOperation(value = "测试是否可以刷票")
    @GetMapping(value = "/testIsOk")
    public String testIsOk(@RequestParam String ipUrl) {
        return brushService.testOk(ipUrl);
    }

    @ApiOperation(value = "更改支付状态")
    @GetMapping(value = "/changeStatus")
    public String changeStatus(@RequestParam Integer id) {
        return brushService.changeStatus(id);
    }


    @ApiOperation(value = "testThread")
    @GetMapping(value = "/testThread")
    public String testThread() {
        brushService.testThread();
        return null;
    }

}
