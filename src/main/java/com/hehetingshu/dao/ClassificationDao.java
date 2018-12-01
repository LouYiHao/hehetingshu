package com.hehetingshu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.hehetingshu.entity.Classification;

@Mapper
public interface ClassificationDao {
	@Select("select * from Classification")
	List<Classification> selectAll();
}
