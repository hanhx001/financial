package com.iboyaa.service;

import java.util.List;

import com.iboyaa.pojo.GPinfo;

public interface IGPinfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(GPinfo record);

    int insertSelective(GPinfo record);

    GPinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GPinfo record);

    int updateByPrimaryKey(GPinfo record);
    
    List<GPinfo> selectAll(Integer state);
    
    void updateRemoteGpData();
    
    String searchRemoteGpData(String code);
    
    List<GPinfo> selectManager();
    
    List<GPinfo> fuzzySearch(GPinfo record);
}