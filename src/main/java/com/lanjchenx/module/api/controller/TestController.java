package com.lanjchenx.module.api.controller;

import com.lanjchenx.dto.ApiResult;
import com.lanjchenx.dto.ApiReturn;
import com.lanjchenx.module.lijiangnew.component.LijiangComp;
import com.lanjchenx.module.lijiangnew.dto.LijiangTouristDto;
import com.lanjchenx.module.lijiangnew.dto.StatusDto;
import com.lanjchenx.module.lijiangnew.dto.TouristRequestDto;
import com.lanjchenx.module.lijiangnew.service.LijiangNewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author admin 2019-12-20 19:42
 */
@Api(value = "TestController", tags = "抢票测试接口")
@RestController
@RequestMapping(value = "api/v1/test")
public class TestController {
    @Resource
    private LijiangComp lijiangComp;

    @ApiOperation(value = "获取时间测试")
    @PostMapping(value = "/timeTest")
    public ApiReturn uploadImage() {
        String i = LijiangComp.getMaxTime();
        return ApiReturn.success("测试通过");
    }

}
