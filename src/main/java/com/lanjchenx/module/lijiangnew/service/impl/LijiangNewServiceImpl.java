package com.lanjchenx.module.lijiangnew.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.lanjchenx.constants.BooleanConstants;
import com.lanjchenx.constants.CommonConstants;
import com.lanjchenx.dto.ApiResult;
import com.lanjchenx.dto.ApiReturn;
import com.lanjchenx.module.lijiangnew.component.LijiangComp;
import com.lanjchenx.module.lijiangnew.dao.*;
import com.lanjchenx.module.lijiangnew.dto.*;
import com.lanjchenx.module.lijiangnew.entity.*;
import com.lanjchenx.module.lijiangnew.service.LijiangNewService;
import com.lanjchenx.module.utils.RandomUtil;
import com.lanjchenx.utils.IdCardUtil;
import com.lanjchenx.utils.IdGen;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.Predicate;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author admin 2019-05-01 15:37
 */
@Service
public class LijiangNewServiceImpl implements LijiangNewService {


    private static final Logger logger = LoggerFactory.getLogger(LijiangNewServiceImpl.class);
    @Autowired
    private LijiangTouristDao lijiangTouristDao;
    @Autowired
    private AccountNumberDao accountNumberDao;
    @Autowired
    private LijiangParameterInfoDao lijiangParameterInfoDao;
    @Autowired
    private LijiangComp lijiangComp;
    @Autowired
    private LijiangValidateInfoDao lijiangValidateInfoDao;
    @Autowired
    private LijiangTokenInfoDao lijiangTokenInfoDao;

    @Override
    public ApiReturn upLoadImages(MultipartFile multipartFile, String validate) {
        try {
            List<LijiangAccountNumber> list = accountNumberDao.findByDelFlagAndImgFlagAndLoginStatusAndUseStatus(1, 1, 1, 1);
            if (list.isEmpty()) {
                return ApiReturn.failure("请先登录一批账号");
            }
            LijiangAccountNumber lijiangTokenInfo = list.get(RandomUtils.nextInt(0, list.size() - 1));
            String token = lijiangTokenInfo.getToken();
            String imageUrl = lijiangComp.httpClientUploadFile(multipartFile, token);
            if (imageUrl.contains("https")) {
                return ApiReturn.success(imageUrl);
            } else {
                return ApiReturn.failure(imageUrl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ApiReturn.failure("系统异常！");
    }

    @Override
    public ApiReturn upLoadImages2(MultipartFile multipartFile, String userGroup, Integer id) {
        LijiangTouristInfo lijiangTouristInfoDemo = lijiangTouristDao.findFirstByUserGroupAndParameterAndAccountNumberIdIsNotNull(userGroup, 0);
        if (lijiangTouristInfoDemo == null) {
            //未分组
            return ApiReturn.failure("请先更新照片再操作");
        }
        LijiangTouristInfo lijiangTouristInfo = lijiangTouristDao.findFirstByIdAndDelFlagAndUserGroupAndParameter(id, 0, userGroup, 0);
        if (lijiangTouristInfo == null) {
            return ApiReturn.failure("游客不存在，请检查用户id或分组标识是否正确");
        }
        LijiangAccountNumber lijiangAccountNumber = accountNumberDao.findOne(lijiangTouristInfoDemo.getAccountNumberId());
        try {
            String imageUrl = lijiangComp.httpClientUploadFile(multipartFile, lijiangAccountNumber.getToken());
            if (imageUrl.contains("https")) {
                lijiangTouristInfo.setAccountNumberId(lijiangTouristInfoDemo.getAccountNumberId());
                lijiangTouristInfo.setFacePicPath(imageUrl);
                lijiangTouristInfo.setImgStatus(1);
                lijiangTouristDao.save(lijiangTouristInfo);
                return ApiReturn.success("保存成功");
            } else {
                return ApiReturn.failure(imageUrl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ApiReturn.failure("系统异常");
    }

    @Override
    public ApiReturn updateImages() {
        List<LijiangTouristInfo> lijiangTouristInfos = lijiangTouristDao.findByDelFlagAndImgStatusAndParameterAndNewFlagAndUserGroupNotNull(0, 0, 0, 1);
        Map<Object, List<LijiangTouristInfo>> map = lijiangTouristInfos.stream().collect(Collectors.groupingBy(LijiangTouristInfo::getUserGroup));
        List<LijiangAccountNumber> lijiangAccountNumbers = accountNumberDao.findSize(map.size());
        if (lijiangAccountNumbers.size() < map.size()) {
            return ApiReturn.failure("登录账号数量不足");
        }
//        LijiangAccountNumber lijiangAccountNumbers = accountNumberDao.findFirstByDelFlagAndLoginStatusAndUseStatus(1, 1, 0);
        AtomicInteger i = new AtomicInteger();
        map.forEach((key, value) -> {
            String token = lijiangAccountNumbers.get(i.get()).getToken();
            Integer accountId = lijiangAccountNumbers.get(i.get()).getId();
            i.getAndIncrement();
            value.forEach(lijiangTouristInfo -> {
                String url = lijiangTouristInfo.getFacePicPath();
                try {
                    URL url1 = new URL(url);
                    URLConnection uc = url1.openConnection();
                    InputStream inputStream = uc.getInputStream();
                    MultipartFile multipartFile = new MockMultipartFile("temp.jpg", "temp.jpg", "image/jpg", inputStream);
                    Thread.sleep(1000);
                    String imageUrl = lijiangComp.httpClientUploadFile(multipartFile, token);
                    if (imageUrl.contains("https")) {
                        lijiangTouristInfo.setFacePicPath(imageUrl);
                        lijiangTouristInfo.setImgStatus(1);
                        lijiangTouristInfo.setAccountNumberId(accountId);
                        lijiangTouristInfo.setMessage("上传成功");
                    } else {
                        lijiangTouristInfo.setMessage(imageUrl);
                    }
                    lijiangTouristDao.save(lijiangTouristInfo);
                    inputStream.close();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
        return ApiReturn.success("更新成功");
    }

    @Override
    public String login(LijiangAccountNumber lijiangAccountNumber) {
        try {
            String token = lijiangComp.login(new AccountNumberDto(lijiangAccountNumber.getPhone(), lijiangAccountNumber.getPassword(), ""));
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
    public ApiReturn login() {
        List<LijiangAccountNumber> lijiangAccountNumbers = accountNumberDao.findByDelFlagAndLoginStatusAndUseStatus(1, 0, 0);
        List<LijiangValidateInfo> validateInfos = lijiangValidateInfoDao.findSize(LocalDateTime.now().toString(), lijiangAccountNumbers.size());
        if (validateInfos.size() < lijiangAccountNumbers.size()) {
            return ApiReturn.failure("验证码数量不够，请添加验证码");
        }
        AtomicInteger i = new AtomicInteger();
        lijiangAccountNumbers.forEach(lijiangAccountNumber1 -> {
            String token = lijiangComp.login(new AccountNumberDto(lijiangAccountNumber1.getPhone(), lijiangAccountNumber1.getPassword(), validateInfos.get(i.get()).getValidate()));
            i.getAndIncrement();
            if (StringUtils.isNotBlank(token)) {
                lijiangAccountNumber1.setToken(token);
                lijiangAccountNumber1.setLoginStatus(1);
            }
        });
        accountNumberDao.save(lijiangAccountNumbers);
//        try {
//            if (StringUtils.isNotBlank(token)) {
//                return token;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.info("---------------------登录异常=----------------");
//        }
        return ApiReturn.success("登陆成功");
    }

    @Override
    public ApiReturn upLoadTourist(TouristRequestDto touristRequestDto) {
        int typeId;
        String vertificateCardName;
        if (touristRequestDto.getType() == 0) {
            if (!StringUtils.equalsIgnoreCase("YES", IdCardUtil.IDCardValidate(touristRequestDto.getIdNumber()))) {
                return ApiReturn.failure("身份证信息有误！！");
            }
            typeId = 1;
            vertificateCardName = "身份证";
        } else {
            vertificateCardName = "护照";
            typeId = 5;
        }
        if (StringUtils.isNotBlank(touristRequestDto.getUserGroup()) && touristRequestDto.getUserGroup().length() != 5) {
            return ApiReturn.failure("分组编号有误");
        }
        if (touristRequestDto.getId() != null) {
            LijiangTouristInfo lijiangTourist = lijiangTouristDao.getOne(touristRequestDto.getId());
            lijiangTourist.setCertificateNo(touristRequestDto.getIdNumber());
            lijiangTourist.setCertificateCardName(vertificateCardName);
            lijiangTourist.setCertificateName(touristRequestDto.getName());
            lijiangTourist.setCertificateTypeId(typeId);
            lijiangTourist.setFacePicPath(touristRequestDto.getImageUrl());
            lijiangTourist.setUserId(touristRequestDto.getUserId());
            lijiangTourist.setDelFlag(0);
            lijiangTourist.setCdate(new Date());
            lijiangTourist.setUserGroup(touristRequestDto.getUserGroup());
            lijiangTourist.setImgStatus(0);
            lijiangTourist.setParameter(0);
            lijiangTourist.setNewFlag(1);
            lijiangTouristDao.save(lijiangTourist);
            return ApiReturn.success("编辑成功");
        }
        if (lijiangTouristDao.findFirstByCertificateNo(touristRequestDto.getIdNumber()) != null) {
            return ApiReturn.failure("游客信息已经存在，请勿重复添加");
        }
        LijiangTouristInfo lijiangTourist = new LijiangTouristInfo();
        lijiangTourist.setCertificateNo(touristRequestDto.getIdNumber());
        lijiangTourist.setCertificateCardName(vertificateCardName);
        lijiangTourist.setCertificateName(touristRequestDto.getName());
        lijiangTourist.setCertificateTypeId(typeId);
        lijiangTourist.setFacePicPath(touristRequestDto.getImageUrl());
        lijiangTourist.setUserId(touristRequestDto.getUserId());
        lijiangTourist.setDelFlag(0);
        lijiangTourist.setCdate(new Date());
        lijiangTourist.setUserGroup(touristRequestDto.getUserGroup());
        lijiangTourist.setImgStatus(0);
        lijiangTourist.setParameter(0);
        lijiangTourist.setNewFlag(1);
        lijiangTouristDao.save(lijiangTourist);
        return ApiReturn.success("保存成功");
    }

    @Override
    public ApiResult<List<LijiangTouristDto>> getAllTourist(StatusDto statusDto) {
        Specification<LijiangTouristInfo> specification = (root, query, cb) -> {
            List<Predicate> predicates = Lists.newArrayList();
            predicates.add(cb.equal(root.get("newFlag").as(Integer.class), 1));
            if (statusDto.getImgStatus() != null) {
                predicates.add(cb.equal(root.get("imgStatus").as(Integer.class), statusDto.getImgStatus()));
            }
            if (statusDto.getParaStatus() != null) {
                predicates.add(cb.equal(root.get("parameter").as(Integer.class), statusDto.getParaStatus()));
            }
            if (statusDto.getPeopleStatus() != null) {
                predicates.add(cb.equal(root.get("delFlag").as(Integer.class), statusDto.getPeopleStatus()));
            }
            if (statusDto.getUserId() != null) {
                predicates.add(cb.equal(root.get("userId").as(Integer.class), statusDto.getUserId()));
            }
            if (statusDto.getGroupStatus() == null) {

            } else if (statusDto.getGroupStatus() == 1) {
                predicates.add(cb.isNotNull(root.get("userGroup").as(String.class)));
            } else {
                predicates.add(cb.isNull(root.get("userGroup").as(String.class)));
            }
            query.where(cb.and(Iterables.toArray(predicates, Predicate.class)));
            query.orderBy(cb.desc(root.get("userGroup").as(String.class)));
            return predicates.isEmpty() ? cb.conjunction() : cb.and(Iterables.toArray(predicates, Predicate.class));
        };
        List<LijiangTouristInfo> list = lijiangTouristDao.findAll(specification);
        List<LijiangTouristDto> list1 = Lists.newArrayList();
        list.forEach(lijiangTouristInfo -> {
            list1.add(new LijiangTouristDto(
                    lijiangTouristInfo.getId(),
                    lijiangTouristInfo.getCertificateNo(),
                    lijiangTouristInfo.getCertificateCardName(),
                    lijiangTouristInfo.getCertificateName(),
                    lijiangTouristInfo.getCertificateTypeId(),
                    lijiangTouristInfo.getPhoneNumber(),
                    lijiangTouristInfo.getFacePicPath(),
                    lijiangTouristInfo.getDelFlag() == 0 ? "未上传" : "已上传",
                    lijiangTouristInfo.getParameter() == 0 ? "未生成" : "已生成",
                    lijiangTouristInfo.getUserId(),
                    lijiangTouristInfo.getAccountNumberId(),
                    lijiangTouristInfo.getUserGroup(),
                    lijiangTouristInfo.getImgStatus() == 0 ? "未上传" : "已上传",
                    lijiangTouristInfo.getNewFlag() == 0 ? "老数据" : "新数据",
                    lijiangTouristInfo.getCdate()
            ));
        });
        ApiResult<List<LijiangTouristDto>> apiResult = new ApiResult<>();
//        List<LijiangTouristInfo> list = Lists.newArrayList();
//        if (userId == 100) {
//            list = lijiangTouristDao.findByDelFlagOrderByUserGroup(0);
//        } else if (delFlag == 1) {
//            list = lijiangTouristDao.findByDelFlagAndUserIdAndUserGroupIsNullOrderByUserGroup(0, userId);
//        } else if (delFlag == 2) {
//            list = lijiangTouristDao.findByDelFlagAndUserIdAndUserGroupIsNotNullOrderByUserGroup(0, userId);
//        } else {
//            list = lijiangTouristDao.findByUserIdAndDelFlagOrderByUserGroup(userId, 0);
//        }
        apiResult.setCode(CommonConstants.ReturnCode.SUCCESS);
        apiResult.setMessage("获取成功");
        apiResult.setData(list1);
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
    public ApiReturn groupAndAddContacts(String userGroup) {
        try {
            //获取分组下账号
            List<LijiangTouristInfo> touristInfoList = lijiangTouristDao.findByDelFlagAndUserGroupAndImgStatus(0, userGroup, 1);
            //获取已经登录的账号
            List<LijiangValidateInfo> validateInfos = lijiangValidateInfoDao.findSize(LocalDateTime.now().toString(), touristInfoList.size());
            if (validateInfos.size() < touristInfoList.size()) {
                return ApiReturn.failure("验证码数量不够，请添加验证码");
            }
            AtomicInteger validateIndex = new AtomicInteger();
            LijiangAccountNumber accountNumber = accountNumberDao.findOne(touristInfoList.get(0).getAccountNumberId());
            String token = accountNumber.getToken();
            Integer accountId = accountNumber.getId();
            touristInfoList.forEach(lijiangTouristInfo -> {
                lijiangTouristInfo.setAccountNumberId(accountId);
                String result = lijiangComp.addContacts(token, new ContactsDto(
                        lijiangTouristInfo.getCertificateTypeId() + "",
                        lijiangTouristInfo.getPhoneNumber(),
                        lijiangTouristInfo.getFacePicPath(),
                        lijiangTouristInfo.getCertificateNo(),
                        lijiangTouristInfo.getCertificateName(),
                        validateInfos.get(validateIndex.get()).getValidate()));
                if (StringUtils.isBlank(result)) {
                    lijiangTouristInfo.setMessage("上传联系人本地程序异常");
                } else if (StringUtils.equals("200", result)) {
                    lijiangTouristInfo.setMessage("上传成功");
                    lijiangTouristInfo.setDelFlag(1);
                } else {
                    lijiangTouristInfo.setMessage(result);
                }
                validateIndex.getAndIncrement();
                accountNumber.setUseStatus(1);
            });
            accountNumberDao.save(accountNumber);
            lijiangTouristDao.save(touristInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiReturn.failure("分配账号游客异常");
        }
        return ApiReturn.success("分配成功");
    }

    @Override
    public ApiReturn setParamet() {
        List<LijiangTouristInfo> lijiangTouristInfos = lijiangTouristDao.findByDelFlagAndImgStatusAndParameterAndNewFlagAndUserGroupNotNull(1, 1, 0, 1);
        Map<Integer, List<LijiangTouristInfo>> map = lijiangTouristInfos.stream().collect(Collectors.groupingBy(LijiangTouristInfo::getAccountNumberId));
        map.forEach((key, value) -> {
            LijiangAccountNumber accountNumber = accountNumberDao.findOne(key);
            List<Parameter.OrderItemsList.OrderCertificateItemsList> orderCertificateItemsLists = Lists.newArrayList();
            value.forEach(lijiangTouristInfo -> {
                Parameter.OrderItemsList.OrderCertificateItemsList orderCertificateItemsList = new Parameter.OrderItemsList.OrderCertificateItemsList();
                BeanUtils.copyProperties(lijiangTouristInfo, orderCertificateItemsList);
                lijiangTouristInfo.setParameter(1);
                orderCertificateItemsLists.add(orderCertificateItemsList);
            });
            Parameter parameter = new Parameter();
            parameter.setOrderNetType("APPGP");
            parameter.setOrderTackTicketName(orderCertificateItemsLists.get(0).getCertificateName());
            parameter.setOrderTackTicketPhone(orderCertificateItemsLists.get(0).getPhoneNumber());
            parameter.setCertificateTypeNo("");
            parameter.setRemark("");
            List<Parameter.OrderItemsList> orderItemsLists = Lists.newArrayList();
            Parameter.OrderItemsList orderItemsList = new Parameter.OrderItemsList();
            orderItemsList.setSaleSum(orderCertificateItemsLists.size());
            //产品id
            orderItemsList.setProductOnlyNo("10000008258");
            orderItemsList.setOrderCertificateItemsList(orderCertificateItemsLists);
            orderItemsList.setArriveDT(LocalDate.now().toString());
            orderItemsList.setProductType("ZHTC");
            orderItemsLists.add(orderItemsList);
            parameter.setOrderItemsList(orderItemsLists);
            parameter.setOrderTimeControlList(null);
            LijiangParameterInfo lijiangParameterInfo = new LijiangParameterInfo();
            lijiangParameterInfo.setParameters(JSONObject.toJSONString(parameter));
            lijiangParameterInfo.setToken(accountNumber.getToken());
            lijiangParameterInfo.setUsername(accountNumber.getPhone());
            lijiangParameterInfo.setPhone(orderCertificateItemsLists.get(0).getPhoneNumber());
            lijiangParameterInfo.setPassword(accountNumber.getPassword());
            lijiangParameterInfo.setCountNumber(orderCertificateItemsLists.size());
            lijiangParameterInfo.setDelFlag(0);
            lijiangParameterInfo.setCreateTime(new Date());
            lijiangParameterInfoDao.save(lijiangParameterInfo);
        });
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
        if (parameterInfos == null) {
            return ApiReturn.failure("今天票为0");
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
        if (parameterInfos == null) {
            return ApiReturn.failure("今天票为0");
        }
        List<List<LijiangParameterInfo>> lists = Lists.partition(parameterInfos, 10);
        for (List<LijiangParameterInfo> list : lists) {
            list.forEach(lijiangParameterInfo -> {
                lijiangComp.saveOrder(lijiangParameterInfo.getToken(), lijiangParameterInfo.getParameters(), lijiangParameterInfo.getId());
            });
            try {
                Thread.sleep(10);
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

    @Override
    @Transactional
    public ApiReturn userGroup(List<Integer> ids, String phone) {
        lijiangTouristDao.updateUserGroup(IdGen.randomString(5), ids, phone);
        return ApiReturn.success("分组成功");
    }

    @Override
    @Transactional
    public ApiReturn deleteUser(List<Integer> ids) {
        lijiangTouristDao.deleteUser(ids);
        return ApiReturn.success("删除成功");
    }

    @Override
    public ApiResult<List<String>> getUserGroup() {
        return new ApiResult<>(lijiangTouristDao.getGroup());
    }

    @Override
    public ApiResult<List<ParameterDto>> getParameter(Integer delFlag) {
        ApiResult<List<ParameterDto>> apiResult = new ApiResult<>();
        List<LijiangParameterInfo> list = lijiangParameterInfoDao.findByDelFlag(delFlag);
        List<ParameterDto> resultList = Lists.newArrayList();
        list.forEach(lijiangParameterInfo -> {
            Parameter parameter = JSONObject.parseObject(lijiangParameterInfo.getParameters(), Parameter.class);
            List<Parameter.OrderItemsList> lists = parameter.getOrderItemsList();
            List<Parameter.OrderItemsList.OrderCertificateItemsList> lists1 = lists.get(0).getOrderCertificateItemsList();
            List<String> nameList = lists1.stream().map(Parameter.OrderItemsList.OrderCertificateItemsList::getCertificateName).collect(Collectors.toList());
            String cardName = lists1.get(0).getCertificateCardName();
            resultList.add(new ParameterDto(lijiangParameterInfo.getDelFlag() == 0 ? "失败" : "成功",
                    lijiangParameterInfo.getMessage(),
                    nameList.toString(),
                    lijiangParameterInfo.getPhone(),
                    lijiangParameterInfo.getUsername(),
                    lijiangParameterInfo.getCountNumber(),
                    cardName, lijiangParameterInfo.getId()
            ));
        });
        apiResult.setData(resultList);
        apiResult.setMessage("获取成功");
        apiResult.setCode(CommonConstants.ReturnCode.SUCCESS);
        return apiResult;
    }

    @Override
    @Transactional
    public ApiReturn loginAccount() {
        List<LijiangAccountNumber> list = accountNumberDao.findByDelFlagAndImgFlagAndLoginStatusAndUseStatus(1, 1, 1, 1);
        List<LijiangValidateInfo> listValidate = lijiangValidateInfoDao.findSize(LocalDateTime.now().toString(), list.size());
        for (int i = 0; i < list.size(); i++) {
            String token = lijiangComp.login(new AccountNumberDto(list.get(i).getPhone(),
                    list.get(i).getPassword(), listValidate.get(i).getValidate()));
            list.get(i).setToken(token);
        }
        accountNumberDao.save(list);
        return ApiReturn.success("登录成功");
    }


    /**
     * 处理参数(分配时间段)
     *
     * @return
     */
    public List<LijiangParameterInfo> parameter() {
        List<LijiangParameterInfo> parameterInfos = lijiangParameterInfoDao.findByDelFlag(0);
        List<LijiangValidateInfo> validateInfos = lijiangValidateInfoDao.findSize(LocalDateTime.now().toString(), parameterInfos.size());
        if (validateInfos.size() < parameterInfos.size()) {
            for (int i = 0; i < parameterInfos.size() - validateInfos.size(); i++) {
                LijiangValidateInfo lijiang = new LijiangValidateInfo();
                lijiang.setValidate("1111111111111");
                validateInfos.add(lijiang);
            }
        }
        AtomicInteger validateIndex = new AtomicInteger(0);
        Map<String, Integer> timeMap = lijiangComp.getTimes();
        AtomicReference<Integer> allCount = new AtomicReference<>(0);
        timeMap.forEach((key, value) -> {
            allCount.updateAndGet(v -> v + value);
        });
        if (allCount.get() == 0) {
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
