package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
