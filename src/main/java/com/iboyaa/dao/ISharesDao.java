package com.iboyaa.dao;

import com.iboyaa.pojo.SharesInfo;

public interface ISharesDao {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(SharesInfo record);

    SharesInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SharesInfo record);

 
}