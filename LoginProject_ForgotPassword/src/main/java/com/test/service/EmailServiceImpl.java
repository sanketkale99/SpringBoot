package com.test.service;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

	public boolean sendEmail(String subject, String message, String to) {
		
		boolean f = false;
		
		String from = "sanketkale770@gmail.com";

		// variable for gmail
		String host = "smtp.elasticemail.com";

		// Set SMTP properties
		Properties props = System.getProperties();
		System.out.println("Properties : " + props);

		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "2525");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.auth", "true");

		// Step 1 : to get the session object
		Session session = Session.getInstance(props, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sanketkale770@gmail.com","B64CAE7DE4979F748DC905A3774616B45601");
//				5ABC1699D7B8E98AB6B559EA1478E80CE987
			}
		});
		session.setDebug(true);

//		step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);

		try {
			// Create message
			m.setFrom(from);
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			
//			m.setText(message);

			m.setContent(message,"text/html");
			
			// Send message
			Transport.send(m);

			System.out.println("Email sent successfully.");
			f = true;
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return f;
	}
}
