package com.lanjchenx.module.api.controller;

import com.lanjchenx.dto.ApiResult;
import com.lanjchenx.dto.ApiReturn;
import com.lanjchenx.module.lijiangnew.dto.ParameterDto;
import com.lanjchenx.module.lijiangnew.dto.PeopleDto;
import com.lanjchenx.module.lijiangnew.entity.LijiangTime;
import com.lanjchenx.module.lijiangnew.entity.LijiangTouristInfo;
import com.lanjchenx.module.lijiangnew.service.LijiangNewService;
import com.lanjchenx.module.lijiangnew.service.LijiangNewService2;
import com.lanjchenx.module.lijiangnew.service.LijiangTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author admin 2019-05-01 15:12
 */
@Api(value = "LijangNewController", tags = "账号/刷票 接口")
@RestController
@RequestMapping(value = "api/v1/lijiangNew")
public class LijangNewController {

    @Resource
    private LijiangNewService lijiangNewService;
    @Resource
    private LijiangNewService2 lijiangNewService2;
    @Resource
    private LijiangTimeService lijiangTimeService;

    @ApiOperation(value = "设置抢票时间")
    @GetMapping(value = "/setTime")
    public ApiReturn setTime(@RequestParam String time) {
        return lijiangTimeService.setTime(time);
    }

    @ApiOperation(value = "获取抢票时间")
    @GetMapping(value = "/getTime")
    public ApiResult<LijiangTime>  getTime() {
        return lijiangTimeService.getTime();
    }

    @ApiOperation(value = "处理订单链接")
    @GetMapping(value = "/getOrderUrl")
    public ApiReturn getOrderUrl() {
        return lijiangNewService2.getOrderUrl();
    }

    @ApiOperation(value = "1：上传联系人,传分组code")
    @GetMapping(value = "/distribution")
    public ApiReturn distribution(@RequestParam String userGroup) {
        return lijiangNewService.groupAndAddContacts(userGroup);
    }

    @ApiOperation(value = "2：生成参数  APP：1，小程序：2")
    @GetMapping(value = "/setParamet")
    public ApiReturn setParamet(@RequestParam Integer type) {
        return lijiangNewService.setParamet(type);
    }

    @ApiOperation(value = "（第一步）刷新token  1：登录，2：删除联系人")
    @GetMapping(value = "/brushToken")
    public ApiReturn brushToken(@RequestParam Integer count) {
        return lijiangNewService.brushToken(count);
    }

    @ApiOperation(value = "（第二步）开始刷票")
    @GetMapping(value = "/brush")
    public ApiReturn brush() {
        return lijiangNewService.brush();
    }

//    @ApiOperation(value = "根据联系人手机号,身份证号，临时删除联系人")
//    @GetMapping(value = "/deletePeople")
//    public ApiReturn deletePeople(@RequestParam String phone, @RequestParam String idCard) {
//        return lijiangNewService.deletePeople(phone, idCard);
//    }

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
    public ApiReturn saveValidate(@RequestParam String validate, @RequestParam Long time) {
        return lijiangNewService.saveValidate(validate, time);
    }

    @ApiOperation(value = "登录账号,上传游客照片所需token")
    @GetMapping(value = "/loginAccountImg")
    public ApiReturn loginAccountImg() {
        return lijiangNewService.loginAccount();
    }

    @ApiOperation(value = "登录账号，重新上传照片，分组")
    @GetMapping(value = "/login")
    public ApiReturn login() {
        return lijiangNewService.login();
    }

    @ApiOperation(value = "获取分组列表")
    @GetMapping(value = "/getUserGroup")
    public ApiResult<List<String>> getUserGroup() {
        return lijiangNewService.getUserGroup();
    }

    @ApiOperation(value = "获取参数列表")
    @GetMapping(value = "/getParameter")
    public ApiResult<List<ParameterDto>> getParameter(@RequestParam Integer delFlag) {
        return lijiangNewService.getParameter(delFlag);
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
