package com.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.redis.mapper.StudentMapper;
import com.redis.pojo.Student;
import com.redis.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public int insert(Student student) {
		System.out.println("插入方法执行了########");
		return studentMapper.insert(student);
	}

	@Override
	@CacheEvict(value="defaultCache",key="'student_id_'+#id")
	public int deleteByPrimaryKey(Long id) {
		System.out.println("删除方法执行了########");
		return studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	@CachePut(value="defaultCache",key="'student_id_'+#student.id")
	public Student updateByPrimaryKey(Student student) {
		System.out.println("修改方法执行了########");
		studentMapper.updateByPrimaryKey(student);
		return student;
	}

	@Override
	@Cacheable(value="defaultCache",key="'student_id_'+#id")//#id
	public Student selectByPrimaryKey(Long id) {
		System.out.println("查询方法执行了########");
		return studentMapper.selectByPrimaryKey(id);
	}

}
