package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository 		//to connect with db like crud opearation 
public interface StudentRepository extends JpaRepository<Student, Long>{

}
