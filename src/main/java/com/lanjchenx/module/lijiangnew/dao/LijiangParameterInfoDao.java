package com.lanjchenx.module.lijiangnew.dao;

import com.lanjchenx.modole.repository.CustomRepository;
import com.lanjchenx.module.lijiangnew.entity.LijiangParameterInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author chenx 2019-02-21 16:36
 */
public interface LijiangParameterInfoDao extends CustomRepository<LijiangParameterInfo, Integer> {

    List<LijiangParameterInfo> findByDelFlagAndUsername(Integer delFlag, String userName);

    List<LijiangParameterInfo> findByDelFlag(Integer delFlag);

    @Modifying
    @Query(value = "update lijiang_parameter_info set del_flag= ?1,message = ?3,order_batch_no=?4 where id= ?2", nativeQuery = true)
    void updateStatus(Integer delFlag, Integer id, String message, String orderBatchNo);

    @Modifying
    @Query(value = "update lijiang_parameter_info set order_url= ?1 where id= ?2", nativeQuery = true)
    void updateUrl(String url, Integer id);

    /**
     * 登录刷新token
     *
     * @return
     */
    @Query(value = "select * from lijiang_parameter_info where del_flag=0  group by username", nativeQuery = true)
    List<LijiangParameterInfo> getParameter();

    /**
     * 删除联系人刷新token
     *
     * @param delFlag
     * @return
     */
    @Query(value = "select * from lijiang_parameter_info where del_flag=?1 and DATE_FORMAT(create_time,'%Y%m%d')=DATE_FORMAT(?2,'%Y%m%d')  group by username", nativeQuery = true)
    List<LijiangParameterInfo> getParameter(Byte delFlag, String time);

    @Query(value = "select * from lijiang_parameter_info where del_flag=1 and DATE_FORMAT(create_time,'%Y%m%d')=DATE_FORMAT(?1,'%Y%m%d')  group by username", nativeQuery = true)
    List<LijiangParameterInfo> deletePerson(String date);

    @Modifying
    @Query(value = "update lijiang_parameter_info set token=?1 where username=?2 ", nativeQuery = true)
    void refreshToken(String token, String username);

    @Query(value = "select * from lijiang_parameter_info limit 0,6", nativeQuery = true)
    List<LijiangParameterInfo> findToken();

}
