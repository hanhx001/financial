/**
 * 
 */
package com.iboyaa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.iboyaa.dao.IBackMoneyDao;
import com.iboyaa.pojo.BackMoney;
import com.iboyaa.service.IBackMoneyService;

/**
 * @author 清水贤人
 *
 */
@Service("backMoneyService")
public class BackMoneyServiceImpl implements IBackMoneyService {

    @Resource
    private IBackMoneyDao backMoneyDao;

    public BackMoneyServiceImpl() {
        // TODO Auto-generated constructor stub
    }


    @Override
    public int insertSelective(BackMoney record) {
        return this.backMoneyDao.insertSelective(record);
    }

    @Override
    public BackMoney selectByPrimaryKey(Integer id) {

        return this.backMoneyDao.selectByPrimaryKey(id);
    }


    @Override
    public int updateByPrimaryKeySelective(BackMoney record) {

        return this.backMoneyDao.updateByPrimaryKeySelective(record);
    }

}
