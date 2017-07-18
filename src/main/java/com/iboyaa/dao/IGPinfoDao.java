package com.iboyaa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iboyaa.pojo.GPinfo;

public interface IGPinfoDao {
	int deleteByPrimaryKey(Integer id);

	int insert(GPinfo record);

	int insertSelective(GPinfo record);

	GPinfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(GPinfo record);

	int updateByPrimaryKey(GPinfo record);

	List<GPinfo> selectAllByC(@Param("ccstate") Integer ccstate, @Param("sort") String sort,
			@Param("order") String order);

	List<GPinfo> selectManager();

	List<GPinfo> fuzzySearch(GPinfo record);

	List<GPinfo> sortable(@Param("ccstate") String ccstate, @Param("order") String order,
			@Param("column") String column);
}