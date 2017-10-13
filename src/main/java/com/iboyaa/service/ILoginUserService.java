/**
 * 
 */
package com.iboyaa.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.iboyaa.pojo.loginUser;

/**
 * @author 清水贤人
 *
 */
public interface ILoginUserService {


    int insertSelective(loginUser record);

    loginUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(loginUser record);

    PageInfo<loginUser> getLoginUserInfoByCondition(String startDate, String endDate,
            String keyWord, Integer pageNum, Integer pageSize);

    loginUser login(String username, String password);
}
