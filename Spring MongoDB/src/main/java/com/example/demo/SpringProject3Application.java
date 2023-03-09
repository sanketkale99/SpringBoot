package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class SpringProject3Application implements CommandLineRunner{

	private final UserRepository userRepository;
	
	@Autowired
	public SpringProject3Application(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringProject3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if(userRepository.findAll().isEmpty()) {
			
			userRepository.save(new User("Mayur","Shinde"));
			userRepository.save(new User("Rushi","Methe"));
			userRepository.save(new User("Sanket","Kale"));
			userRepository.save(new User("Abhi","Gavhane"));
			userRepository.save(new User("Adi","S"));
			
		}
		
		for(User user : userRepository.findAll()) {
			System.out.println(user);
		}
	}

}
