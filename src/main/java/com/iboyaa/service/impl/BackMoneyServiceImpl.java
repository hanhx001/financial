/**
 * 
 */
package com.iboyaa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.iboyaa.dao.IBackMoneyDao;
import com.iboyaa.pojo.BackMoney;
import com.iboyaa.service.IBackMoneyService;
import com.iboyaa.util.StringIsNull;

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


    @Override
    public PageInfo<BackMoney> getBackMoneyDatas(String startDate, String endDate, String keyWord,
            Integer pageNum, Integer pageSize) {
        
        DateTime nowTime = new DateTime();

        //如果时间都为空，则查询当天的数据
        if (StringIsNull.isNULL(startDate) && StringIsNull.isNULL(endDate)) {
            startDate = nowTime.toString("yyyy-MM-dd");
            endDate = nowTime.toString("yyyy-MM-dd");
        }
        
        List<BackMoney> backMoneys = backMoneyDao.getBackMoneyDatas(startDate, endDate, keyWord, pageNum, pageSize);
        Integer totalNum = backMoneyDao.getBackMoneyDatas(startDate, endDate, keyWord).size();
        

        //封装分页参数
        PageInfo<BackMoney> pageInfo = new PageInfo<BackMoney>();
        pageInfo.setList(backMoneys);
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(totalNum);
        
        return pageInfo;
    }

}
