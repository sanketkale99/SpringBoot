package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.entity.Course;
import com.spring.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{


	   @Autowired
	   private CourseRepository courseRepository;

	   public List<Course> getAllCourses() {
	       return courseRepository.findAll();
	   }

	   public Course getCourseById(int id) {
	       return courseRepository.findById(id).orElse(null);
	   }

	   public void saveOrUpdateCourse(Course course) {
		   courseRepository.save(course);
	   }

	   public void deleteCourse(Course course) {
		   courseRepository.delete(course);
		}
	
	}


