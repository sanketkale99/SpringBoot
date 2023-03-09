package com.spring.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.login.entity.User;

@Controller
public class RegisterController {

	@Autowired
	private com.spring.login.repository.UserRepository userRepository;

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String registerUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "register";
		}

		User existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser != null) {
			model.addAttribute("error", "A user with that email address already exists.");
			return "register";
		}

		userRepository.save(user);

		return "redirect:/login";
	}

}
