/**
 * 
 */
package com.iboyaa.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.iboyaa.pojo.BackMoney;

/**
 * @author 清水贤人
 *
 */
public interface IBackMoneyService {


    int insertSelective(BackMoney record);

    BackMoney selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackMoney record);

    /**
     * 根据筛选条件查询 回款信息
     * @param startDate
     * @param endDate
     * @param keyWord
     * @param pageNum
     * @param pageSize
     * @return
     * @author 清水贤人
     * @version 2017年9月26日  下午5:23:42
     */
    PageInfo<BackMoney> getBackMoneyDatas(String startDate, String endDate, String keyWord,
            Integer pageNum, Integer pageSize);

}
