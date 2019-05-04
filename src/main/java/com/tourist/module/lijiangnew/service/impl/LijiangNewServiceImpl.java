package com.tourist.module.lijiangnew.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.lanjchenx.constants.CommonConstants;
import com.lanjchenx.dto.ApiResult;
import com.lanjchenx.dto.ApiReturn;
import com.lanjchenx.utils.IdCardUtil;
import com.tourist.module.brushticket.dto.Paramet;
import com.tourist.module.lijiangnew.component.LijiangComp;
import com.tourist.module.lijiangnew.dao.AccountNumberDao;
import com.tourist.module.lijiangnew.dao.LijiangParameterInfoDao;
import com.tourist.module.lijiangnew.dao.LijiangTouristDao;
import com.tourist.module.lijiangnew.dto.*;
import com.tourist.module.lijiangnew.entity.LijiangAccountNumber;
import com.tourist.module.lijiangnew.entity.LijiangParameterInfo;
import com.tourist.module.lijiangnew.entity.LijiangTouristInfo;
import com.tourist.module.lijiangnew.service.LijiangNewService;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author admin 2019-05-01 15:37
 */
@Service
public class LijiangNewServiceImpl implements LijiangNewService {


    private static final Logger logger = LoggerFactory.getLogger(LijiangNewServiceImpl.class);
    @Resource
    private LijiangTouristDao lijiangTouristDao;
    @Resource
    private AccountNumberDao accountNumberDao;
    @Resource
    private LijiangParameterInfoDao lijiangParameterInfoDao;
    @Resource
    private LijiangComp lijiangComp;

    @Override
    public ApiReturn upLoadImages(MultipartFile multipartFile) {
        try {
            List<LijiangAccountNumber> lijiangAccountNumberList = accountNumberDao.findByDelFlag(0);
            String token = this.login(lijiangAccountNumberList.get(RandomUtils.nextInt(0, 193)));
            if (StringUtils.isBlank(token)) {
                return ApiReturn.failure("登录异常！");
            }
            String imageUrl = lijiangComp.httpClientUploadFile(multipartFile, token);
            if (StringUtils.isBlank(imageUrl)) {
                return ApiReturn.failure("请上传本人自拍！！");
            }
            return ApiReturn.success(imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ApiReturn.failure("上传图片失败！");
    }

    @Override
    public String login(LijiangAccountNumber lijiangAccountNumber) {
        String token = "";
        try {
            token = lijiangComp.login(new AccountNumberDto(lijiangAccountNumber.getPhone(), lijiangAccountNumber.getPassword()));
            if (StringUtils.isNotBlank(token)) {
                return token;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("---------------------登录异常=----------------");
        }
        return null;
    }

    @Override
    public ApiReturn upLoadTourist(TouristRequestDto touristRequestDto) {
        if (!StringUtils.equalsIgnoreCase("YES", IdCardUtil.IDCardValidate(touristRequestDto.getIdNumber()))) {
            return ApiReturn.failure("身份证信息有误！！");
        }
        if (lijiangTouristDao.findFirstByCertificateNo(touristRequestDto.getIdNumber()) != null) {
            return ApiReturn.failure("游客信息已经存在，请勿重复添加");
        }
        LijiangTouristInfo lijiangTourist = new LijiangTouristInfo();
        lijiangTourist.setCertificateNo(touristRequestDto.getIdNumber());
        lijiangTourist.setCertificateCardName("身份证");
        lijiangTourist.setCertificateName(touristRequestDto.getName());
        lijiangTourist.setCertificateTypeId(1);
        lijiangTourist.setFacePicPath(touristRequestDto.getImageUrl());
        lijiangTourist.setUserId(touristRequestDto.getUserId());
        lijiangTourist.setDelFlag(0);
        lijiangTouristDao.save(lijiangTourist);
        return ApiReturn.success("保存成功");
    }

    @Override
    public ApiResult<List<LijiangTouristInfo>> getAllTourist(Integer userId) {
        ApiResult<List<LijiangTouristInfo>> apiResult = new ApiResult<>();
        List<LijiangTouristInfo> list = Lists.newArrayList();
        if (userId == 100) {
            list = lijiangTouristDao.findAll();
        } else {
            list = lijiangTouristDao.findByUserId(userId);
        }
        apiResult.setCode(CommonConstants.ReturnCode.SUCCESS);
        apiResult.setMessage("获取成功");
        apiResult.setData(list);
        return apiResult;
    }

    @Override
    public ApiResult<List<LijiangTouristInfo>> getTouristByName(String name) {
        ApiResult<List<LijiangTouristInfo>> apiResult = new ApiResult<>();
        List<LijiangTouristInfo> list = lijiangTouristDao.findAllByCertificateName(name);
        apiResult.setCode(CommonConstants.ReturnCode.SUCCESS);
        apiResult.setMessage("获取成功");
        apiResult.setData(list);
        return apiResult;
    }

    @Override
    @Transactional
    public ApiReturn groupAndAddContacts(Integer beginSize, Integer endSize) {
        try {
            //10个游客分一组
            List<LijiangTouristInfo> touristInfoList = lijiangTouristDao.findByDelFlag(0);
            List<List<LijiangTouristInfo>> list10 = Lists.partition(touristInfoList, 10);
            //获取账号
            List<LijiangAccountNumber> accountNumberList = accountNumberDao.getAccountNumber(beginSize, endSize);
            if (list10.size() > accountNumberList.size()) {
                logger.info("------------账号数量不够----------------");
                return ApiReturn.failure("账号数量不够,重新获取");
            }
            //为账号分配游客
            for (int i = 0; i < list10.size(); i++) {
                //一个账号添加10个游客
                List<LijiangTouristInfo> listTourist = list10.get(i);
                String userName = accountNumberList.get(i).getPhone();
                String password = accountNumberList.get(i).getPassword();
                String token = lijiangComp.login(new AccountNumberDto(userName, password));
                List<Parameter.OrderItemsList.OrderCertificateItemsList> orderCertificateItemsLists = Lists.newArrayList();
                listTourist.forEach(lijiangTouristInfo -> {
                    Parameter.OrderItemsList.OrderCertificateItemsList orderCertificateItemsList = new Parameter.OrderItemsList.OrderCertificateItemsList();
                    BeanUtils.copyProperties(lijiangTouristInfo, orderCertificateItemsList);
                    lijiangComp.addContacts(token, new ContactsDto(
                            lijiangTouristInfo.getCertificateTypeId() + "",
                            lijiangTouristInfo.getPhoneNumber(),
                            lijiangTouristInfo.getFacePicPath(),
                            lijiangTouristInfo.getCertificateNo(),
                            lijiangTouristInfo.getCertificateName()
                    ));
                    orderCertificateItemsLists.add(orderCertificateItemsList);
                });
                List<List<Parameter.OrderItemsList.OrderCertificateItemsList>> lists = Lists.partition(orderCertificateItemsLists, 5);
                lists.forEach(list5 -> {
                    Parameter parameter = new Parameter();
                    parameter.setOrderNetType("APPGP");
                    parameter.setOrderTackTicketName(list5.get(0).getCertificateName());
                    parameter.setOrderTackTicketPhone(list5.get(0).getPhoneNumber());
                    parameter.setArriveDT(LocalDate.now() + "");
                    parameter.setCertificateTypeNo(list5.get(0).getCertificateNo());
                    parameter.setRemark("");
                    List<Parameter.OrderItemsList> orderItemsLists = Lists.newArrayList();
                    Parameter.OrderItemsList orderItemsList = new Parameter.OrderItemsList();
                    orderItemsList.setSaleSum(list5.size());
                    //产品id
                    orderItemsList.setProductOnlyNo("10000008037");
                    orderItemsList.setOrderCertificateItemsList(list5);
                    orderItemsLists.add(orderItemsList);
                    parameter.setOrderItemsList(orderItemsLists);
                    parameter.setOrderTimeControlList(null);
                    LijiangParameterInfo lijiangParameterInfo = new LijiangParameterInfo();
                    lijiangParameterInfo.setParameters(JSONObject.toJSONString(parameter));
                    lijiangParameterInfo.setToken(token);
                    lijiangParameterInfo.setUsername(userName);
                    lijiangParameterInfo.setPhone(list5.get(0).getPhoneNumber());
                    lijiangParameterInfo.setPassword(password);
                    lijiangParameterInfo.setCountNumber(list5.size());
                    lijiangParameterInfo.setDelFlag(0);
                    lijiangParameterInfoDao.save(lijiangParameterInfo);
                });
            }
            touristInfoList.forEach(touristInfo -> {
                touristInfo.setDelFlag(1);
            });
            lijiangTouristDao.save(touristInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            ApiReturn.failure("分配账号游客异常");
        }
        return ApiReturn.success("分配成功");
    }

    @Override
    public ApiReturn brushToken() {
        List<LijiangParameterInfo> parameterInfos = lijiangParameterInfoDao.findByDelFlag(0);
        parameterInfos.forEach(lijiangParameterInfo -> {
            lijiangParameterInfo.setToken(lijiangComp.login(new AccountNumberDto(
                    lijiangParameterInfo.getUsername(), lijiangParameterInfo.getPassword())));
        });
        lijiangParameterInfoDao.save(parameterInfos);
        return ApiReturn.success("token刷新成功");
    }

    @Override
    public ApiReturn brush() {
        List<LijiangParameterInfo> parameterInfos = this.parameter();
        parameterInfos.forEach(lijiangParameterInfo -> {
            lijiangComp.saveOrder(lijiangParameterInfo.getToken(), lijiangParameterInfo.getParameters(), lijiangParameterInfo.getId());
        });
        return ApiReturn.success("任务完成！");
    }

    @Override
    public ApiReturn deletePeople(String phone, String idCard) {
        List<LijiangParameterInfo> parameterInfos = lijiangParameterInfoDao.findByDelFlagAndUsername(0, phone);
        parameterInfos.forEach(parameterInfo -> {
            Parameter parameter = JSONObject.parseObject(parameterInfo.getParameters(), Parameter.class);
            parameter.getOrderItemsList().forEach(orderItemsList -> {
                List<Parameter.OrderItemsList.OrderCertificateItemsList> lists = orderItemsList.getOrderCertificateItemsList();
                for (int i = 0; i < lists.size(); i++) {
                    if (StringUtils.equals(idCard, lists.get(i).getCertificateNo())) {
                        lists.remove(lists.get(i));
                        parameter.setOrderTackTicketName(lists.get(0).getCertificateName());
                        parameter.setOrderTackTicketPhone(lists.get(0).getPhoneNumber());
                        parameter.setCertificateTypeNo(lists.get(0).getCertificateNo());
                        parameterInfo.setParameters(JSONObject.toJSONString(parameter));
                        return;
                    }
                }
            });
        });
        lijiangParameterInfoDao.save(parameterInfos);
        return ApiReturn.success("删除成功");
    }

    @Override
    public ApiReturn deleteAllPeople() {
        List<LijiangParameterInfo> lijiangParameterInfos = lijiangParameterInfoDao.findAll();
        lijiangParameterInfos.forEach(lijiangParameterInfo -> {
            String token = lijiangParameterInfo.getToken();
            lijiangComp.getContacts(token).forEach(s -> {
                lijiangComp.deleteContacts(token, s);
            });
        });
        return ApiReturn.success("删除成功");
    }

    @Override
    public ApiResult<List<PeopleDto>> getOrderStatus() {
        ApiResult<List<PeopleDto>> apiResult = new ApiResult<>();
        List<LijiangParameterInfo> parameterInfos = lijiangParameterInfoDao.findAll();
//        Map<String, List<LijiangParameterInfo>> collect = parameterInfos.stream().collect(Collectors.groupingBy(LijiangParameterInfo::getUsername));
//        collect.forEach((key, value) -> {
//            peopleDto.setStatus();
//        });
        List<PeopleDto> listResult = Lists.newArrayList();
        parameterInfos.forEach(lijiangParameterInfo -> {
            PeopleDto peopleDto = new PeopleDto();
            peopleDto.setStatus(lijiangParameterInfo.getDelFlag() == 0 ? "未完成" : "订单创建成功");
            peopleDto.setUserName(lijiangParameterInfo.getUsername());
            List<PeopleDto.User> list = Lists.newArrayList();
            JSONObject jsonObject = JSONObject.parseObject(lijiangParameterInfo.getParameters());
            ((JSONObject) jsonObject.getJSONArray("orderItemsList").get(0))
                    .getJSONArray("orderCertificateItemsList").forEach(js -> {
                PeopleDto.User user = new PeopleDto.User();
                JSONObject people = (JSONObject) js;
                user.setName(people.getString("certificateName"));
                user.setIdCard(people.getString("certificateNo"));
                list.add(user);
            });
            peopleDto.setUserList(list);
            listResult.add(peopleDto);
        });
        apiResult.setCode(CommonConstants.ReturnCode.SUCCESS);
        apiResult.setMessage("获取成功");
        apiResult.setData(listResult);
        return apiResult;
    }


    /**
     * 处理参数(分配时间段)
     *
     * @return
     */
    private List<LijiangParameterInfo> parameter() {
        List<LijiangParameterInfo> parameterInfos = lijiangParameterInfoDao.findByDelFlag(0);
        Map<String, Integer> timeMap = lijiangComp.getTimes();
        Double coefficient = 1D;
        AtomicInteger i = new AtomicInteger();
        List<LijiangParameterInfo> newParameter = Lists.newArrayList();
        timeMap.forEach((key, value) -> {
            //本时间段内分配任务量
            int taskCount = (int) (value * coefficient);
            Integer count = 0;
            while (true) {
                if (i.get() >= parameterInfos.size()) {
                    logger.info("-----------所有票已经分完==========");
                    return;
                }
                if (taskCount < count) {
                    logger.info("-----------本时间段已经分发完毕==========任务量:{}" + taskCount);
                    return;
                }
                LijiangParameterInfo lijiangParameterInfo = parameterInfos.get(i.get());
                Parameter.OrderTimeControlList orderTimeControlList = new Parameter.OrderTimeControlList();
                orderTimeControlList.setScenicSpotsId(10000000000002L);
                orderTimeControlList.setTimeControlDetailId(Long.parseLong(key));
                List<Parameter.OrderTimeControlList> list = Lists.newArrayList();
                list.add(orderTimeControlList);
                StringBuilder stringBuilder = new StringBuilder(lijiangParameterInfo.getParameters());
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                lijiangParameterInfo.setParameters((stringBuilder.append(",\"orderTimeControlList\": ").append(JSONObject.toJSONString(list)).append("}")).toString());
                newParameter.add(lijiangParameterInfo);
                count += lijiangParameterInfo.getCountNumber();
                i.getAndIncrement();
            }
        });
        return newParameter;
    }

}
