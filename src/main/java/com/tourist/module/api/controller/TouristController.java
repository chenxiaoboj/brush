package com.tourist.module.api.controller;

import com.tourist.module.brushticket.service.BrushService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenx 2019-02-22 16:34
 */
@Api(value = "TouristController", tags = "")
@RestController
@RequestMapping(value = "api/v1/tourist")
public class TouristController {

    @Resource
    private BrushService brushService;

    @ApiOperation(value = "抓取ip")
    @GetMapping(value = "/getIps")
    public String getIps() {
        return brushService.getIps();
    }
    @ApiOperation(value = "开始刷票")
    @GetMapping(value = "/brush")
    public String brush(@RequestParam String goodId) {
        return brushService.brush(goodId);
    }
}
