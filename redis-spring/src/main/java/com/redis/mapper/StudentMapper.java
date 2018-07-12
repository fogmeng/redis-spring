package com.redis.mapper;

import org.apache.ibatis.annotations.Param;

import com.redis.pojo.Student;

public interface StudentMapper {

	int insert(Student student);//增加数据
	
	int deleteByPrimaryKey(@Param("id")Long id);//删除数据
	
	int updateByPrimaryKey(Student student);//修改数据
	
	Student selectByPrimaryKey(@Param("id")Long id);//查询数据
	
}
