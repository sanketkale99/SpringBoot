package com.test.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.test.dto.UserRegisterDto;
import com.test.entity.User;


public interface UserService extends UserDetailsService{
	
	User save(UserRegisterDto registerDto);

	
	
}
