package com.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.dto.UserRegisterDto;
import com.test.service.UserService;

@Controller
@RequestMapping("/register")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public String showRegistrationForm(Model model)
	{
		model.addAttribute("user", new UserRegisterDto());
		return "register";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegisterDto user)
	{
		userService.save(user);
		return "redirect:/register?success";
	}
	
}
