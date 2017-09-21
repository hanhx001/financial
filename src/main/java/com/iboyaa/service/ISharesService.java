package com.iboyaa.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.iboyaa.pojo.SharesInfo;

/**
 * 股票Services
 * @author 清水贤人
 *
 */
public interface ISharesService {


    /**
     * 查询股票名称
     * @param code 股票代码
     * @return 股票名称
     * @author 清水贤人
     * @version 2017年9月18日  上午10:56:13
     */
    String getSharesName(String code);

    /**
     * 根据主键删除股票信息
     * @param id
     * @return
     * @author 清水贤人
     * @version 2017年9月18日  下午2:06:07
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 根据条件保存股票数据
     * @param record
     * @return
     * @author 清水贤人
     * @version 2017年9月18日  下午2:06:14
     */
    int insertSelective(SharesInfo record);

    /**
     * 根据主键查询股票
     * @param id
     * @return
     * @author 清水贤人
     * @version 2017年9月18日  下午2:06:19
     */
    SharesInfo selectByPrimaryKey(Integer id);

    /**
     * 根据条件 更新股票
     * @param record
     * @return
     * @author 清水贤人
     * @version 2017年9月18日  下午2:06:26
     */
    int updateByPrimaryKeySelective(SharesInfo record);


    /**
     * 用于根据股票状态、时间、关键字查询股票数据
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @param keyWord   复合关键字，模糊查询该记录中所有匹配的记录
     * @param flag      股票状态：分为持仓（1）、止盈（2）、止损（3）
     * @param sort      排序规则：0 是按照总盈亏率倒叙；1 是按照日盈亏率排序
     * @return          股票List
     * @author 清水贤人
     * @version 2017年9月20日  下午5:35:22
     */
    PageInfo getSharesDataByCondition(String startDate, String endDate, String keyWord,
            String flag, String sort,Integer pageNum, Integer pageSize);


}
