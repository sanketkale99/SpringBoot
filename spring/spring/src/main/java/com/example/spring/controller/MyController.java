package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.spring.entity.Course;
import com.example.spring.service.CourseService;

@Controller
public class MyController {
	
	@Autowired //autowired call all the dependency injection(getter,setter,constructor,implementation classes) using object creation.
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> getcourses()
	{
		return this.courseService.getCourses();
	}

}
