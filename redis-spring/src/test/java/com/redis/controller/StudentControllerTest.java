package com.redis.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.redis.pojo.Student;
import com.redis.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/applicationContext-dao.xml", "classpath:/spring/applicationContext-redis.xml",
		"classpath:/spring/applicationContext-service.xml" })
public class StudentControllerTest {

	private MockMvc mvc;

	@Autowired
	private StudentService studentService;

	@Before
	public void setup() {
		System.out.println("111111");
		this.mvc = MockMvcBuilders.standaloneSetup(new StudentController()).build();
		System.out.println("2222");
	}

	@Test
	public void contextLoads() throws Exception {
		System.out.println("3333");
		//RequestBuilder request = get("redis-spring/rest/select").param("id", "2");
		RequestBuilder request = get("/select").param("id", "2");
		mvc.perform(request).andExpect(status().isOk())
				.andExpect(content().string("{\"id\":\"2\",\"name\":\"b\",\"age\":\"10\",\"sex\":\"0\"}"));
	}

	@Test
	public void select() {
		Student student = studentService.selectByPrimaryKey((long) 2);
		System.out.println(student.getName().toString());
	}
}
