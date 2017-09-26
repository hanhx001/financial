package com.iboyaa.dao;

import com.iboyaa.pojo.BackMoney;

public interface IBackMoneyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BackMoney record);

    int insertSelective(BackMoney record);

    BackMoney selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackMoney record);

    int updateByPrimaryKey(BackMoney record);
}