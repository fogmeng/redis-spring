package com.redis.service;

import com.redis.pojo.Student;

public interface StudentService {

	int insert(Student student);//增加数据
	
	int deleteByPrimaryKey(Long id);//删除数据
	
	Student updateByPrimaryKey(Student student);//修改数据
	
	Student selectByPrimaryKey(Long id);//查询数据
}
