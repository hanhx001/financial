package com.iboyaa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iboyaa.pojo.BackMoney;

public interface IBackMoneyDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BackMoney record);

    int insertSelective(BackMoney record);

    BackMoney selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackMoney record);

    int updateByPrimaryKey(BackMoney record);

    /**
     * 带分页的查询回款信息s
     * @param startDate
     * @param endDate
     * @param keyWord
     * @param pageNum
     * @param pageSize
     * @return
     * @author 清水贤人
     * @version 2017年9月26日  下午5:26:37
     */
    List<BackMoney> getBackMoneyDatas(@Param("startDate") String startDate,
            @Param("endDate") String endDate, @Param("keyWord") String keyWord,
            @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 不带分页的查询回款信息
     * @param startDate
     * @param endDate
     * @param keyWord
     * @return
     * @author 清水贤人
     * @version 2017年9月26日  下午5:26:43
     */
    List<BackMoney> getBackMoneyDatas(@Param("startDate") String startDate,
            @Param("endDate") String endDate, @Param("keyWord") String keyWord);
}
