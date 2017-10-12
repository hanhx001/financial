package com.iboyaa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
 
import com.iboyaa.pojo.loginUser;

public interface loginUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(loginUser record);

    int insertSelective(loginUser record);

    loginUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(loginUser record);

    int updateByPrimaryKey(loginUser record);
    
    List<loginUser> getLoginUserInfoByCondition(@Param("startDate") String startDate,
            @Param("endDate") String endDate, @Param("keyWord") String keyWord,
            @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    
    List<loginUser> getLoginUserInfoByCondition(@Param("startDate") String startDate,
            @Param("endDate") String endDate, @Param("keyWord") String keyWord
            );
    
    loginUser userlogin( @Param("username")String username, @Param("password")String password);
}