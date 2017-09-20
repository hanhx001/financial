package com.iboyaa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iboyaa.pojo.SharesInfo;

public interface ISharesDao {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(SharesInfo record);

    SharesInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SharesInfo record);

    List<SharesInfo> getSharesDataByCondition(@Param("startDate") String startDate,
            @Param("endDate") String endDate, @Param("keyWord") String keyWord,
            @Param("flag") String flag, @Param("sort") String sort);



}
