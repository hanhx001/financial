package com.iboyaa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iboyaa.pojo.SharesInfo;

public interface ISharesDao {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(SharesInfo record);

    SharesInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SharesInfo record);

    /**
     * 带分页的查询股票详情接口
     * @param startDate
     * @param endDate
     * @param keyWord
     * @param position
     * @param sort
     * @param pageNum
     * @param pageSize
     * @return
     * @author 清水贤人
     * @version 2017年9月21日  下午5:59:54
     */
    List<SharesInfo> getSharesDataByCondition(@Param("startDate") String startDate,
            @Param("endDate") String endDate, @Param("keyWord") String keyWord,
            @Param("position") String position, @Param("sort") String sort,
            @Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 不带分页的查询股票详情接口
     * @param startDate
     * @param endDate
     * @param keyWord
     * @param position
     * @param sort
     * @return
     * @author 清水贤人
     * @version 2017年9月21日  下午6:00:35
     */
    List<SharesInfo> getSharesDataByCondition(@Param("startDate") String startDate,
            @Param("endDate") String endDate, @Param("keyWord") String keyWord,
            @Param("position") String position, @Param("sort") String sort);


}
