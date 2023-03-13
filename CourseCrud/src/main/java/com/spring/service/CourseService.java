package com.spring.service;

import java.util.List;

import com.spring.entity.Course;

public interface CourseService {

	public List<Course> getAllCourses();

	public Course getCourseById(int id);

	public void saveOrUpdateCourse(Course course);

	public void deleteCourse(Course course);
}
