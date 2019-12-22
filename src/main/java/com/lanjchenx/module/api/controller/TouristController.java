package com.lanjchenx.module.api.controller;

import com.lanjchenx.dto.ApiResult;
import com.lanjchenx.dto.ApiReturn;
import com.lanjchenx.module.lijiangnew.dto.LijiangTouristDto;
import com.lanjchenx.module.lijiangnew.dto.StatusDto;
import com.lanjchenx.module.lijiangnew.dto.TouristRequestDto;
import com.lanjchenx.module.lijiangnew.entity.LijiangTouristInfo;
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
@Api(value = "TouristController", tags = "游客管理接口")
@RestController
@RequestMapping(value = "api/v1/tourist")
public class TouristController {
    @Resource
    private LijiangNewService lijiangNewService;

    @ApiOperation(value = "上传游客图片")
    @PostMapping(value = "/uploadImage")
    public ApiReturn uploadImage(@RequestParam MultipartFile file, @RequestParam String validate) {
        return lijiangNewService.upLoadImages(file, validate);
    }

    @ApiOperation(value = "第二次上传游客图片，为游客分配账号")
    @GetMapping(value = "/updateImage")
    public ApiReturn uploadImage() {
        return lijiangNewService.updateImages();
    }

    @ApiOperation(value = "上传游客信息")
    @PostMapping(value = "/uploadTourist")
    public ApiReturn getTourist(@Valid @RequestBody TouristRequestDto touristRequestDto) {
        return lijiangNewService.upLoadTourist(touristRequestDto);
    }

    @ApiOperation(value = "获取游客列表")
    @PostMapping(value = "/getAllTourist")
    public ApiResult<List<LijiangTouristDto>> getAllTourist(StatusDto statusDto) {
        return lijiangNewService.getAllTourist(statusDto);
    }
    @ApiOperation(value = "为游客分组")
    @GetMapping(value = "/userGroup")
    public ApiReturn userGroup(@RequestParam List<Integer> ids) {
        if (ids.size() > 5) {
            return ApiReturn.failure("分组人数过多，请重新选择");
        }
        return lijiangNewService.userGroup(ids);
    }
    @ApiOperation(value = "删除联系人")
    @GetMapping(value = "/deleteUser")
    public ApiReturn deleteUser(@RequestParam List<Integer> ids) {
        return lijiangNewService.deleteUser(ids);
    }
}
