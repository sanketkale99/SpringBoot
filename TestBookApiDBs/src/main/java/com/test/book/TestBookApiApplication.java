package com.test.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestBookApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestBookApiApplication.class, args);
		
		//database name - book_api
		//tables - book, author
	}
	
}
