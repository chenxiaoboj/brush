package com.tourist.module.api.controller;

import com.tourist.common.ApiResult;
import com.tourist.module.brushticket.entity.BrushExceptionInfo;
import com.tourist.module.brushticket.entity.SuccessOrderInfo;
import com.tourist.module.brushticket.service.BrushService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author chenx 2019-02-22 16:34
 */
@Api(value = "TouristController", tags = "丽江刷票工具接口")
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

    @ApiOperation(value = "处理状态为3的异常数据接口（支付二维码地址）")
    @GetMapping(value = "/disposeException")
    public String getEwmUrl() {
        return brushService.disposeException();
    }

    @ApiOperation(value = "获取订单列表（支付二维码）地址列表")
    @GetMapping(value = "/getOrderList")
    public ApiResult<List<SuccessOrderInfo>> disposeException() {
        ApiResult<List<SuccessOrderInfo>> apiResult = new ApiResult<>();
        List<SuccessOrderInfo> list = brushService.getEwmList();
        apiResult.setCode("0000");
        apiResult.setData(list);
        apiResult.setCount(list.size()+"");
        apiResult.setMsg("获取成功！");
        return apiResult;
    }

    @ApiOperation(value = "处理状态为其他的异常数据接口（i/o异常）")
    @GetMapping(value = "/disposeExceptionIO")
    public String disposeException(@RequestParam String ipUrl) {
        return brushService.disposeExceptionIO(ipUrl);
    }

    @ApiOperation(value = "测试是否可以刷票")
    @GetMapping(value = "/testIsOk")
    public String testIsOk(@RequestParam String ipUrl) {
        return brushService.testOk(ipUrl)+"";
    }

    @ApiOperation(value = "更改支付状态")
    @GetMapping(value = "/changeStatus")
    public String changeStatus(@RequestParam Integer id) {
        return brushService.changeStatus(id);
    }

    @ApiOperation(value = "查看异常数据")
    @GetMapping(value = "/getExecptionList")
    public ApiResult<List<BrushExceptionInfo>> getExecptionList() {
        ApiResult<List<BrushExceptionInfo>> apiResult = new ApiResult<>();
        List<BrushExceptionInfo> list = brushService.getExceptionList();
        apiResult.setCode("0000");
        apiResult.setData(list);
        apiResult.setCount(list.size()+"");
        apiResult.setMsg("获取成功！");
        return apiResult;
    }


    @ApiOperation(value = "testThread")
    @GetMapping(value = "/testThread")
    public String testThread() {
        brushService.testThread();
        return null;
    }
    @ApiOperation(value = "分组")
    @GetMapping(value = "/fenzu")
    public String fenzu() {
        brushService.fenzu();
        return null;
    }
    @ApiOperation(value = "测试ip")
    @GetMapping(value = "/ips")
    public String testThread(@RequestParam String ipUrl) {
        brushService.ips(ipUrl);
        return "success";
    }

}
