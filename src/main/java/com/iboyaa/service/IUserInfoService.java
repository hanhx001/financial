/**
 * 
 */
package com.iboyaa.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.iboyaa.pojo.UserInfo;

/**
 * 用户基本信息
 * @author 清水贤人
 *
 */
public interface IUserInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);


    /**
     * 用于根据筛选条件查询 人员基本信息数据
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @param keyWord   复合关键字，模糊查询该记录中所有匹配的记录
     * @param state      人员状态
     * @return          人员List
     * @author 清水贤人
     */
    PageInfo<UserInfo> getUserInfo(String startDate, String endDate, String keyWord, Integer state,
            Integer pageNum, Integer pageSize);
}
