/**
 * 
 */
package com.iboyaa.service;

import com.iboyaa.pojo.BackMoney;

/**
 * @author 清水贤人
 *
 */
public interface IBackMoneyService {
   

    int insertSelective(BackMoney record);

    BackMoney selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BackMoney record);
 
}
