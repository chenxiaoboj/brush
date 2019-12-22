package com.lanjchenx.module.lijiangnew.service;

import com.lanjchenx.dto.ApiResult;
import com.lanjchenx.dto.ApiReturn;
import com.lanjchenx.module.lijiangnew.dto.LijiangTouristDto;
import com.lanjchenx.module.lijiangnew.dto.PeopleDto;
import com.lanjchenx.module.lijiangnew.dto.StatusDto;
import com.lanjchenx.module.lijiangnew.dto.TouristRequestDto;
import com.lanjchenx.module.lijiangnew.entity.LijiangAccountNumber;
import com.lanjchenx.module.lijiangnew.entity.LijiangTouristInfo;
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
    ApiReturn upLoadImages(MultipartFile multipartFile,String validate);
    /**
     * 上传游客信息
     *
     * @return
     */
    ApiReturn updateImages();

    /**
     * 登录（数据库验证码登录）
     *
     * @param lijiangAccountNumber
     * @return
     */
    String login(LijiangAccountNumber lijiangAccountNumber);

    /**
     * 登录(通过前端传递验证码登录)
     *
     * @return
     */
    ApiReturn login();

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
    ApiResult<List<LijiangTouristDto>> getAllTourist(StatusDto statusDto);

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
    ApiReturn groupAndAddContacts(String userGroup);
    /**
     * 生成参数
     *
     * @return
     */
    ApiReturn setParamet();


    /**
     * 刷新token
     *
     * @return
     */
    ApiReturn brushToken(Integer count);

    /**
     * 启动刷票
     *
     * @return
     */
    ApiReturn brush();
    /**
     * 启动刷票
     *
     * @return
     */
    ApiReturn brushOrd();

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

    /**
     * 添加验证码
     *
     * @return
     */
    ApiReturn saveValidate(String validate,Long expirationTime);

    /**
     * 为游客分组
     *
     * @return
     */
    ApiReturn userGroup( List<Integer> ids);
    /**
     * 批量删除游客
     *
     * @return
     */
    ApiReturn deleteUser( List<Integer> ids);

    /**
     * 获取游客分组标识
     *
     * @return
     */
    ApiResult<List<String>> getUserGroup();

    /**
     * 登录一批token传照片
     *
     * @return
     */
    ApiReturn loginAccount();




}
