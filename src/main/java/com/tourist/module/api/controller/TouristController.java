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

    @ApiOperation(value = "获取支付二维码地址列表")
    @GetMapping(value = "/brush")
    public String getEwmUrl(@RequestParam String goodId, @RequestParam Double coefficient) {
        return null;
    }

    @ApiOperation(value = "处理异常数据接口")
    @GetMapping(value = "/brush")
    public String disposeException(@RequestParam String goodId, @RequestParam Double coefficient) {
        return brushService.disposeException();
    }

    @ApiOperation(value = "测试是否可以刷票")
    @GetMapping(value = "/brush")
    public String testIsOk(@RequestParam String goodId, @RequestParam Double coefficient) {
        return null;
    }

    @ApiOperation(value = "更改支付状态")
    @GetMapping(value = "/brush")
    public String changeStatus(@RequestParam Integer id) {
        return brushService.changeStatus(id);
    }

    @ApiOperation(value = "抓取ip  count>10：去抓页面ip，count<10 从json文件获取ip")
    @GetMapping(value = "/getIps")
    public String getIps(@RequestParam Integer count) {
        return brushService.getIps(count);
    }

    @ApiOperation(value = "testThread")
    @GetMapping(value = "/testThread")
    public String testThread() {
        brushService.testThread();
        return null;
    }

}
