package com.tourist.module.lijiangnew.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.lanjchenx.constants.BooleanConstants;
import com.lanjchenx.constants.CommonConstants;
import com.lanjchenx.dto.ApiResult;
import com.lanjchenx.dto.ApiReturn;
import com.lanjchenx.utils.IdCardUtil;
import com.tourist.module.lijiangnew.component.LijiangComp;
import com.tourist.module.lijiangnew.component.ScheduledExecutor;
import com.tourist.module.lijiangnew.dao.*;
import com.tourist.module.lijiangnew.dto.*;
import com.tourist.module.lijiangnew.entity.*;
import com.tourist.module.lijiangnew.service.LijiangNewService;
import com.tourist.module.utils.RandomUtil;
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
import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

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
    @Resource
    private LijiangValidateInfoDao lijiangValidateInfoDao;
    @Resource
    private LijiangTokenInfoDao lijiangTokenInfoDao;
    @Resource
    private ScheduledExecutor scheduledExecutor;

    @Override
    public ApiReturn upLoadImages(MultipartFile multipartFile, String validate) {
        try {
//            List<LijiangAccountNumber> lijiangAccountNumberList = accountNumberDao.findByDelFlag(0);
//            String token = this.login(lijiangAccountNumberList.get(RandomUtils.nextInt(0, 193)), validate);
            List<LijiangTokenInfo> tokenInfoList = lijiangTokenInfoDao.findByDelFlag(0);
            if (tokenInfoList.isEmpty()) {
                return ApiReturn.failure("请先登录一批账号");
            }
            LijiangTokenInfo lijiangTokenInfo = tokenInfoList.get(RandomUtils.nextInt(0, tokenInfoList.size() - 1));
            String token = lijiangTokenInfo.getToken();
//            if (StringUtils.isBlank(token)) {
//                return ApiReturn.failure("登录异常！");
//            }
            String imageUrl = lijiangComp.httpClientUploadFile(multipartFile, token);
            if (imageUrl.contains("https")) {
                return ApiReturn.success(imageUrl);
            } else if (StringUtils.equals("51005", imageUrl) || StringUtils.equals("51008", imageUrl)) {
                lijiangTokenInfo.setDelFlag(1);
                lijiangTokenInfoDao.save(lijiangTokenInfo);
                return ApiReturn.failure("登录过期，请换其他账号！！");
            }
            return ApiReturn.failure("请上传本人自拍！！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ApiReturn.failure("上传图片失败！");
    }

    @Override
    public String login(LijiangAccountNumber lijiangAccountNumber) {
        String token = "";
        try {
            token = lijiangComp.login(new AccountNumberDto(lijiangAccountNumber.getPhone(), lijiangAccountNumber.getPassword(), ""));
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
    public String login(LijiangAccountNumber lijiangAccountNumber, String validate) {
        String token = "";
        try {
            token = lijiangComp.login(new AccountNumberDto(lijiangAccountNumber.getPhone(), lijiangAccountNumber.getPassword(), validate));
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
        if (touristRequestDto.getId() != null) {
            LijiangTouristInfo lijiangTourist = lijiangTouristDao.getOne(touristRequestDto.getId());
            lijiangTourist.setCertificateNo(touristRequestDto.getIdNumber());
            lijiangTourist.setCertificateCardName("身份证");
            lijiangTourist.setCertificateName(touristRequestDto.getName());
            lijiangTourist.setCertificateTypeId(1);
            lijiangTourist.setFacePicPath(touristRequestDto.getImageUrl());
            lijiangTourist.setUserId(touristRequestDto.getUserId());
            lijiangTourist.setDelFlag(0);
            lijiangTouristDao.save(lijiangTourist);
            return ApiReturn.success("编辑成功");
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
            list = lijiangTouristDao.findByDelFlag(0);
        } else {
            list = lijiangTouristDao.findByUserIdAndDelFlag(userId, 0);
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
    public ApiReturn groupAndAddContacts(Integer beginSize, Integer endSize) {
        try {
            //10个游客分一组
            List<LijiangTouristInfo> touristInfoList = lijiangTouristDao.findByDelFlag(0);
            //获取账号
            List<LijiangAccountNumber> accountNumberList = accountNumberDao.getAccountNumber(beginSize, endSize);
            List<LijiangValidateInfo> validateInfos = lijiangValidateInfoDao.findSize(LocalDateTime.now().toString(), touristInfoList.size() + accountNumberList.size());
            if (validateInfos.size() < touristInfoList.size()) {
                return ApiReturn.failure("验证码数量不够，请添加验证码");
            }
            AtomicInteger validateIndex = new AtomicInteger();
            List<List<LijiangTouristInfo>> list10 = Lists.partition(touristInfoList, 5);
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
                String token = lijiangComp.login(new AccountNumberDto(userName, password, validateInfos.get(validateIndex.get()).getValidate()));
                validateIndex.getAndIncrement();
                List<Parameter.OrderItemsList.OrderCertificateItemsList> orderCertificateItemsLists = Lists.newArrayList();
                listTourist.forEach(lijiangTouristInfo -> {
                    Parameter.OrderItemsList.OrderCertificateItemsList orderCertificateItemsList = new Parameter.OrderItemsList.OrderCertificateItemsList();
                    BeanUtils.copyProperties(lijiangTouristInfo, orderCertificateItemsList);
                    lijiangComp.addContacts(token, new ContactsDto(
                            lijiangTouristInfo.getCertificateTypeId() + "",
                            lijiangTouristInfo.getPhoneNumber(),
                            lijiangTouristInfo.getFacePicPath(),
                            lijiangTouristInfo.getCertificateNo(),
                            lijiangTouristInfo.getCertificateName(),
                            validateInfos.get(validateIndex.get()).getValidate()
                    ));
                    validateIndex.getAndIncrement();
                    orderCertificateItemsLists.add(orderCertificateItemsList);
                });
                List<List<Parameter.OrderItemsList.OrderCertificateItemsList>> lists = Lists.partition(orderCertificateItemsLists, 5);
                for (List<Parameter.OrderItemsList.OrderCertificateItemsList> list5 : lists) {
                    Parameter parameter = new Parameter();
                    parameter.setOrderNetType("APPGP");
                    parameter.setOrderTackTicketName(list5.get(0).getCertificateName());
                    parameter.setOrderTackTicketPhone(list5.get(0).getPhoneNumber());
                    parameter.setCertificateTypeNo("");
                    parameter.setRemark("");
                    List<Parameter.OrderItemsList> orderItemsLists = Lists.newArrayList();
                    Parameter.OrderItemsList orderItemsList = new Parameter.OrderItemsList();
                    orderItemsList.setSaleSum(list5.size());
                    //产品id
                    orderItemsList.setProductOnlyNo("10000008258");
                    orderItemsList.setOrderCertificateItemsList(list5);
                    orderItemsList.setArriveDT(LocalDate.now().toString());
                    orderItemsList.setProductType("ZHTC");
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
                    lijiangParameterInfo.setCreateTime(new Date());
                    lijiangParameterInfoDao.save(lijiangParameterInfo);
                }
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
    @Transactional
    public ApiReturn brushToken(Integer count) {
        List<LijiangParameterInfo> loginParameter = null;
        if (count == 1) {
            //登录
            loginParameter = lijiangParameterInfoDao.getParameter();
        } else {
            //删联系人
            loginParameter = lijiangParameterInfoDao.getParameter(BooleanConstants.TRUE.CODE, LocalDate.now().minusDays(1).toString());
        }
        List<LijiangValidateInfo> validateInfos = lijiangValidateInfoDao.findSize(LocalDateTime.now().toString(), loginParameter.size());
        if (loginParameter.size() > validateInfos.size()) {
            return ApiReturn.failure("验证码数量不足！！");
        }
        for (int i = 0; i < loginParameter.size(); i++) {
            String username = loginParameter.get(i).getUsername();
            String password = loginParameter.get(i).getPassword();
            String token = lijiangComp.login(new AccountNumberDto(
                    username, password, validateInfos.get(i).getValidate()));
            lijiangParameterInfoDao.refreshToken(token, username);
        }
        lijiangValidateInfoDao.delete(validateInfos);
        return ApiReturn.success("token刷新成功");
    }

    @Override
    public ApiReturn brush() {
        List<LijiangParameterInfo> parameterInfos = this.parameter();
        if (parameterInfos==null){
            return  ApiReturn.failure("今天票为0");
        }
        List<List<LijiangParameterInfo>> lists = Lists.partition(parameterInfos, 10);
        for (List<LijiangParameterInfo> list : lists) {
            list.forEach(lijiangParameterInfo -> {
                lijiangComp.saveOrder(lijiangParameterInfo.getToken(), lijiangParameterInfo.getParameters(), lijiangParameterInfo.getId());
            });
        }
        return ApiReturn.success("执行完成");
    }

    @Override
    public ApiReturn brushOrd() {
        List<LijiangParameterInfo> parameterInfos = this.parameter();
        if (parameterInfos==null){
            return  ApiReturn.failure("今天票为0");
        }
        List<List<LijiangParameterInfo>> lists = Lists.partition(parameterInfos, 10);
        for (List<LijiangParameterInfo> list : lists) {
            list.forEach(lijiangParameterInfo -> {
                lijiangComp.saveOrder(lijiangParameterInfo.getToken(), lijiangParameterInfo.getParameters(), lijiangParameterInfo.getId());
            });
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ApiReturn.success("执行完成");
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
                        parameter.setCertificateTypeNo("");
                        orderItemsList.setSaleSum(parameterInfo.getCountNumber() - 1);
                        parameterInfo.setParameters(JSONObject.toJSONString(parameter));
                        parameterInfo.setCountNumber(parameterInfo.getCountNumber() - 1);
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
        List<LijiangParameterInfo> lijiangParameterInfos = lijiangParameterInfoDao.deletePerson(LocalDate.now().minusDays(1).toString());
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

    @Override
    public ApiReturn saveValidate(String validate, Long expirationTime) {
        LijiangValidateInfo lijiangValidateInfo = new LijiangValidateInfo();
        lijiangValidateInfo.setValidate(validate);
        lijiangValidateInfo.setValueDate(Date.from(Instant.from(LocalDateTime.now().plusMinutes(expirationTime).atZone(ZoneId.systemDefault()))));
        lijiangValidateInfo.setDelFlag(0);
        lijiangValidateInfoDao.save(lijiangValidateInfo);
        return ApiReturn.success("保存成功");
    }


    /**
     * 处理参数(分配时间段)
     *
     * @return
     */
    public List<LijiangParameterInfo> parameter() {
        List<LijiangParameterInfo> parameterInfos = lijiangParameterInfoDao.findByDelFlag(0);
        List<LijiangValidateInfo> validateInfos = lijiangValidateInfoDao.findSize(LocalDateTime.now().toString(), parameterInfos.size());
        AtomicInteger validateIndex = new AtomicInteger(0);
        Map<String, Integer> timeMap = lijiangComp.getTimes();
        AtomicReference<Integer> allCount = new AtomicReference<>(0);
        timeMap.forEach((key, value) -> {
            allCount.updateAndGet(v -> v + value);
        });
        if (allCount.get()==0){
            logger.info("<<<<<<<<<<<<<<<<<<<<<<<今天的票量为0>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            return null;
        }
        int count1 = parameterInfos.stream().mapToInt(LijiangParameterInfo::getCountNumber).sum();
        Double coefficient = count1 / (allCount.get().doubleValue());
        AtomicInteger i = new AtomicInteger();
        List<LijiangParameterInfo> newParameter = Lists.newArrayList();
        timeMap.forEach((key, value) -> {
            //本时间段内分配任务量
            int taskCount = (int) (value * coefficient + 1);
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
                lijiangParameterInfo.setParameters((stringBuilder.append(",\"orderTimeControlList\": ")
                        .append(JSONObject.toJSONString(list)).append(",\"arriveDT\": \"").append(LocalDate.now()).append("\"").append(",\"createOrderUuid\": \"").append(System.currentTimeMillis()).append(RandomUtil.getRandomString(8)).append("\"")
                        .append(",\"validate\": \"")
                        .append(validateInfos.get(validateIndex.get()).getValidate())
                        .append("\"")
                        .append("}")).toString());
                newParameter.add(lijiangParameterInfo);
                validateIndex.set(validateIndex.get() + 1);
                count += lijiangParameterInfo.getCountNumber();
                i.getAndIncrement();
            }
        });
        return newParameter;
    }


//    /**
//     * 抓取ip
//     *
//     * @param ipUrl
//     * @return
//     */
//    public List<BrushTicketInfo> getIp(String ipUrl) {
//        List<BrushTicketInfo> ipMap = Lists.newArrayList();
//        Map<String, Integer> map = Maps.newHashMap();
//        try {
//            Document document = Jsoup.connect(ipUrl).get();
//            String ips = document.body().text();
//            String[] ipArray = ips.split(";");
//            for (int i = 0; i < ipArray.length; i++) {
//                map.put(ipArray[i].split(":")[0], Integer.parseInt(ipArray[i].split(":")[1]));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        map.forEach((key, value) -> {
//            BrushTicketInfo brushTicketInfo = new BrushTicketInfo();
//            brushTicketInfo.setHostName(key);
//            brushTicketInfo.setPort(value);
//            ipMap.add(brushTicketInfo);
//        });
//        return ipMap;
//    }

}
