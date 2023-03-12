package com.test.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	/*
	@RequestMapping( value = "/about", method = RequestMethod.GET )
	public String about(Model model) {
		
		System.out.println(" In the about handler ");
		model.addAttribute("name","sanket kale");
		model.addAttribute("currentdate", new Date().toLocaleString());
		
		String nameString= "abc";
		nameString.toUpperCase();
		return "about";
	}

	@RequestMapping("/index")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	@RequestMapping("/register")
	public String register()
	{
		return "register";
	}
	
	@RequestMapping("/forgot_password")
	public String forgot_password()
	{
		return "forgot_password";
	}
	
	@RequestMapping("/thankyou")
	public String thankyou()
	{
		return "thank_you";
	}
	

//	@PostMapping("/login")
//	public String login(HttpServletRequest request) {
//	    // Check user credentials and set session attributes
//	    // ...
//	    return "redirect:/dashboard.html";
//	}
	

//	@RequestMapping("/home")
//	public String home(Model model)
//	{
//		model.addAttribute("welcome", "welcome to linkcode");
//		model.addAttribute("fee",200000);
//		return "home";
//	}
	
	*/
}
