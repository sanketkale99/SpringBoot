package com.test.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.dto.UserRegisterDto;
import com.test.entity.User;
import com.test.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	// constructor injection
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public User save(UserRegisterDto registerDto) {
		User user = new User(registerDto.getUsername(), registerDto.getEmail(),
				passwordEncoder.encode(registerDto.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(usernameOrEmail);
		if (user == null) {
			user = userRepository.findByUsername(usernameOrEmail);
		}
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username or email: " + usernameOrEmail);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user));

	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(User user) {
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public User getUser(long id) {

		return null;
	}

	public User getUserByName(String username) {
	    Optional<User> optional = Optional.ofNullable(userRepository.getByUsername(username));
	    return optional.orElseThrow(() -> new RuntimeException("User not found for name : " + username));
	}

}
