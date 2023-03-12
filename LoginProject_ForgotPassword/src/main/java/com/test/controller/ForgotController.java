package com.test.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.service.EmailService;

@Controller
public class ForgotController {

	@Autowired
	EmailService emailService;

	Random random = new Random(1000);

	@RequestMapping("/forgot_password")
	public String openEMailForm() {
		return "forgot_password";
	}

	@PostMapping("/send-otp")
	public String sendOTP(@RequestParam("email") String email, HttpSession session) {
		System.out.println("Email : " + email);

		// generating 4 digit OTP

		int otp = random.nextInt(9999);

		System.out.println("OTP: " + otp);

		// code for send OTP to email
		String subject = " OTP for reset Password ";
		String message = "<div style='border:1px solid #e2e2e2; padding:20px'>" + "<h1>" + " OTP is" + "<b>" + otp
				+ "</n>" + "</h1>" + "</div>";
		String to = email;
		boolean flag = this.emailService.sendEmail(subject, message, to);

		if (flag) {
			session.setAttribute("otp", otp);
			return "verify_otp";
		} else {
			session.setAttribute("message", "Something went wrong. Check your email id !!");
			return "forgot_password";
		}
	}

}
