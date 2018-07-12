package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redis.pojo.Student;
import com.redis.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/insert")
	public void insert(Student student){
		
		studentService.insert(student);
		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Student update(Student student){
		
		Student result = studentService.updateByPrimaryKey(student);
		return result;
		
	}
	
	@RequestMapping("/select")
	@ResponseBody
	public Student select(Long id){
		System.out.println(id);
		Student student = studentService.selectByPrimaryKey(id);
		return student;
		
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public int delete(Long id){
		
		int result = studentService.deleteByPrimaryKey(id);
		
		return result;
		
	}

}
