package com.iboyaa.dao;

import java.util.List;

import com.iboyaa.pojo.GPinfo;

public interface IGPinfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(GPinfo record);

    int insertSelective(GPinfo record);

    GPinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GPinfo record);

    int updateByPrimaryKey(GPinfo record);
    
    List<GPinfo> selectAllByC(Integer state);
    List<GPinfo> selectManager();
}