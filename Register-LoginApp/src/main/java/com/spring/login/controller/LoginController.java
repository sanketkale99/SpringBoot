package com.spring.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
	@Autowired
	private AuthenticationManager authenticationManager;
	
    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password, 
                               Model model, HttpSession session) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth instanceof AnonymousAuthenticationToken) {
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
                auth = authenticationManager.authenticate(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            session.setAttribute("user", auth.getName());
            return "redirect:/";
        } catch (AuthenticationException ex) {
            model.addAttribute("error", "Invalid email address or password");
            return "login";
        }
    }
    
}

