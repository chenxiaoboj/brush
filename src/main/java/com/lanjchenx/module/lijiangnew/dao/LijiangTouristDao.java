package com.lanjchenx.module.lijiangnew.dao;

import com.lanjchenx.modole.repository.CustomRepository;
import com.lanjchenx.module.lijiangnew.entity.LijiangTouristInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author chenx 2019-02-21 16:36
 */
public interface LijiangTouristDao extends CustomRepository<LijiangTouristInfo, Integer> {

    LijiangTouristInfo findFirstByCertificateNo(String idNumber);

    LijiangTouristInfo findFirstByIdAndDelFlagAndUserGroupAndParameter(Integer id, Integer delFlag, String userGroup, Integer parameter);

    LijiangTouristInfo findFirstByUserGroupAndParameterAndAccountNumberIdIsNotNull(String userGroup, Integer parameter);

    List<LijiangTouristInfo> findAllByCertificateName(String name);

    List<LijiangTouristInfo> findByDelFlagOrderByUserGroup(Integer delFlag);

    List<LijiangTouristInfo> findByDelFlagAndImgStatusAndParameterAndNewFlagAndUserGroupNotNull(Integer delFlag, Integer status, Integer parameter, Integer newFlag);

    List<LijiangTouristInfo> findByUserIdAndDelFlagOrderByUserGroup(Integer userId, Integer delFlag);

    @Query(value = "update lijiang_tourist_info set user_group = ?1,phone_number=?3 where del_flag=0 and img_status=0 and new_flag=1 and parameter=0 and id in ?2", nativeQuery = true)
    @Modifying
    void updateUserGroup(String userGroup, List<Integer> ids, String phone);

    @Query(value = "delete from lijiang_tourist_info where id in ?1", nativeQuery = true)
    @Modifying
    void deleteUser(List<Integer> ids);

    @Query(value = "update lijiang_tourist_info set new_flag = 0 where new_flag=1", nativeQuery = true)
    @Modifying
    void updateNewFlag();

    @Query(value = "select user_group from lijiang_tourist_info group by user_group having count(0)<5", nativeQuery = true)
    List<String> getGroup();

    List<LijiangTouristInfo> findByDelFlagAndUserIdAndUserGroupIsNullOrderByUserGroup(Integer delFlag, Integer userId);

    List<LijiangTouristInfo> findByDelFlagAndUserGroupAndImgStatus(Integer delFlag, String userGroup, Integer imgStatus);

    List<LijiangTouristInfo> findByDelFlagAndUserIdAndUserGroupIsNotNullOrderByUserGroup(Integer delFlag, Integer userId);

}
