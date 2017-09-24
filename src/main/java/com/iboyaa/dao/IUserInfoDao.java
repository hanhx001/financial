package com.iboyaa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iboyaa.pojo.UserInfo;

public interface IUserInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 带分页的查询人员基本信息
     * @param startDate
     * @param endDate
     * @param keyWord
     * @param state
     * @param pageNum
     * @param pageSize
     * @return
     * @author 清水贤人
     * @version 2017年9月24日  下午12:02:02
     */
    List<UserInfo> getUserInfoByCondition(@Param("startDate") String startDate,
            @Param("endDate") String endDate, @Param("keyWord") String keyWord,
            @Param("state") Integer state, @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize);


    /**
     * 不带分页的查询人员基本信息
     * @param startDate
     * @param endDate
     * @param keyWord
     * @param state
     * @return
     * @author 清水贤人
     * @version 2017年9月24日  下午12:02:34
     */
    List<UserInfo> getUserInfoByCondition(@Param("startDate") String startDate,
            @Param("endDate") String endDate, @Param("keyWord") String keyWord,
            @Param("state") Integer state);
}
