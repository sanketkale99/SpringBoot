package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.entity.User;
import com.test.service.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

//	@GetMapping("/")
//	public String viewHomePage(@PathVariable(value = "id") long id, Model model) {
////		model.addAttribute("user", userService.getUserByName());
//		return "home";
//	}

	@GetMapping("/")
	public String viewHomePage() {
		return "home";
	}

//	@GetMapping("/users/{username}")
//	public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
//	    User user = userService.getUserByName(username);
//	    return ResponseEntity.ok(user);
//	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate() {
		return "update_user";
	}

	@GetMapping("/deleteUser")
	public String deleteStudent() {
		return "redirect:/";
	}
}
