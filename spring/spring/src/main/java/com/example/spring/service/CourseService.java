package com.example.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring.entity.Course;


public interface CourseService {

	public List<Course> getCourses();
}
