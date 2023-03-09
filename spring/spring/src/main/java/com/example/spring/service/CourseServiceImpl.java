package com.example.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring.entity.Course;

@Service
public class CourseServiceImpl implements CourseService{

	List<Course> list;
	
	public CourseServiceImpl() {
		
		list=new ArrayList<>();
		
		list.add(new Course(100,"CoreJava","This is Java OOPs complete course"));
		list.add(new Course(101,"SpringBoot","This is spring boot course "));
	}
	
	@Override
	public List<Course> getCourses() {
		
		return null;
	}

}
