/**
 * 
 */
package com.iboyaa.service;

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
}
