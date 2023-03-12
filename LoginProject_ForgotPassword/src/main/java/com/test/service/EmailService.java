package com.test.service;

public interface EmailService {

	boolean sendEmail(String subject, String message, String to);
	
}
