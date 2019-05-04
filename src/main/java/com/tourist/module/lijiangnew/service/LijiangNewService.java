package com.tourist.module.lijiangnew.service;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.lanjchenx.dto.ApiResult;
import com.lanjchenx.dto.ApiReturn;
import com.tourist.module.lijiangnew.dto.PeopleDto;
import com.tourist.module.lijiangnew.dto.TouristRequestDto;
import com.tourist.module.lijiangnew.entity.LijiangAccountNumber;
import com.tourist.module.lijiangnew.entity.LijiangTouristInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author admin 2019-05-01 15:37
 */
public interface LijiangNewService {

    /**
     * 上传游客信息
     *
     * @param multipartFile
     * @return
     */
    ApiReturn upLoadImages(MultipartFile multipartFile);

    /**
     * 登录
     *
     * @param lijiangAccountNumber
     * @return
     */
    String login(LijiangAccountNumber lijiangAccountNumber);

    /**
     * 添加游客到本地数据库
     *
     * @param touristRequestDto
     * @return
     */
    ApiReturn upLoadTourist(TouristRequestDto touristRequestDto);

    /**
     * 获取全部游客信息
     *
     * @return
     */
    ApiResult<List<LijiangTouristInfo>> getAllTourist(Integer userId);

    /**
     * 根据姓名获取游客信息
     *
     * @param name
     * @return
     */
    ApiResult<List<LijiangTouristInfo>> getTouristByName(String name);

    /**
     * 分配账号并添加联系人
     *
     * @return
     */
    ApiReturn groupAndAddContacts(Integer beginSize, Integer endSize);


    /**
     * 刷新token
     *
     * @return
     */
    ApiReturn brushToken();

    /**
     * 启动刷票
     *
     * @return
     */
    ApiReturn brush();

    /**
     * 临时删除游客
     *
     * @param phone
     * @param idCard
     * @return
     */
    ApiReturn deletePeople(String phone, String idCard);

    /**
     * 删除所有账号常用联系人
     *
     * @return
     */
    ApiReturn deleteAllPeople();

    /**
     * 获取账户/联系人/订单状态信息
     *
     * @return
     */
    ApiResult<List<PeopleDto>> getOrderStatus();


}
