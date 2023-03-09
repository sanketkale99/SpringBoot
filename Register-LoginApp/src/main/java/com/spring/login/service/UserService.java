package com.spring.login.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.login.entity.User;

public interface UserService {

	User registerNewUser(UserRegistrationDto userRegistrationDto);

    void updateUser(User user);

    void deleteUserById(Long id);

    User getUserById(Long id);

    User getUserByEmail(String email);

    List<User> getAllUsers();
}
