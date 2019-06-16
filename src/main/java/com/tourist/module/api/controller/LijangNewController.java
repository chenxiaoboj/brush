package com.tourist.module.api.controller;

import com.lanjchenx.dto.ApiResult;
import com.lanjchenx.dto.ApiReturn;
import com.tourist.module.lijiangnew.component.LijiangComp;
import com.tourist.module.lijiangnew.dao.LijiangParameterInfoDao;
import com.tourist.module.lijiangnew.dto.PeopleDto;
import com.tourist.module.lijiangnew.dto.TouristRequestDto;
import com.tourist.module.lijiangnew.entity.LijiangParameterInfo;
import com.tourist.module.lijiangnew.entity.LijiangTouristInfo;
import com.tourist.module.lijiangnew.service.LijiangNewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author admin 2019-05-01 15:12
 */
@Api(value = "LijangNewController", tags = "丽江新接口")
@RestController
@RequestMapping(value = "api/v1/lijiangNew")
public class LijangNewController {

    @Resource
    private LijiangNewService lijiangNewService;
    @Resource
    private LijiangComp lijiangComp;
    @Resource
    private LijiangParameterInfoDao lijiangParameterInfoDao;

    @ApiOperation(value = "上传游客图片")
    @PostMapping(value = "/uploadImage")
    public ApiReturn uploadImage(@RequestParam MultipartFile file, @RequestParam String validate) {
        return lijiangNewService.upLoadImages(file, validate);
    }

    @ApiOperation(value = "上传游客信息")
    @PostMapping(value = "/uploadTourist")
    public ApiReturn getTourist(@Valid @RequestBody TouristRequestDto touristRequestDto) {
        return lijiangNewService.upLoadTourist(touristRequestDto);
    }

    @ApiOperation(value = "获取全部游客信息")
    @GetMapping(value = "/getAllTourist")
    public ApiResult<List<LijiangTouristInfo>> getAllTourist(@RequestParam Integer userId) {
        return lijiangNewService.getAllTourist(userId);
    }

    @ApiOperation(value = "按名字查用户")
    @GetMapping(value = "/getTouristByName")
    public ApiResult<List<LijiangTouristInfo>> getTouristByName(@RequestParam(required = true) String name) {
        return lijiangNewService.getTouristByName(name);
    }

    @ApiOperation(value = "（提前）为账号分配游客")
    @GetMapping(value = "/distribution")
    public ApiReturn distribution(@RequestParam Integer beginSize, @RequestParam Integer endSize) {
        return lijiangNewService.groupAndAddContacts(beginSize, endSize);
    }

    @ApiOperation(value = "（第一步）刷新token  1：登录，2：删除联系人")
    @GetMapping(value = "/brushToken")
    public ApiReturn brushToken(@RequestParam Integer count) {
        return lijiangNewService.brushToken(count);
    }

    @ApiOperation(value = "（第二步）开始刷票")
    @GetMapping(value = "/brush")
    public ApiReturn brush(@RequestParam String ipUrl) {
        return lijiangNewService.brush(ipUrl);
    }

    @ApiOperation(value = "根据联系人手机号,身份证号，临时删除联系人")
    @GetMapping(value = "/deletePeople")
    public ApiReturn deletePeople(@RequestParam String phone, @RequestParam String idCard) {
        return lijiangNewService.deletePeople(phone, idCard);
    }

    @ApiOperation(value = "给账号清空常用联系人")
    @GetMapping(value = "/deleteAllPeople")
    public ApiReturn deleteAllPeople() {
        return lijiangNewService.deleteAllPeople();
    }

    @ApiOperation(value = "获取账户/联系人/订单状态信息")
    @GetMapping(value = "/getOrderStatus")
    public ApiResult<List<PeopleDto>> getOrderStatus() {
        return lijiangNewService.getOrderStatus();
    }

    @ApiOperation(value = "添加验证码")
    @GetMapping(value = "/saveValidate")
    public ApiReturn saveValidate(@RequestParam String validate,@RequestParam Long time) {
        return lijiangNewService.saveValidate(validate,time);
    }

//    @ApiOperation(value = "test")
//    @GetMapping(value = "/test")
//    public ApiReturn test() {
//        List<LijiangParameterInfo> parameterInfos = lijiangParameterInfoDao.findByDelFlag(0);
//        parameterInfos.forEach(lijiangParameterInfo -> {
//            lijiangComp.saveOrder(lijiangParameterInfo.getToken(), lijiangParameterInfo.getParameters(), lijiangParameterInfo.getId());
//        });
//        return ApiReturn.success("任务完成！");
//    }


}
