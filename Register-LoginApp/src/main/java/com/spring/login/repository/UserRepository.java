package com.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.login.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
}
