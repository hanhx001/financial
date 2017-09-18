/**
 * 
 */
package com.iboyaa.service;

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

    
}
