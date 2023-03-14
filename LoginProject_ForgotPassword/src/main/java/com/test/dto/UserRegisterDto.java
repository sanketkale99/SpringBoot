package com.test.dto;

public class UserRegisterDto {

	private String name;
	private String username;
	private String email;
	private String city;
	private String password;

	public UserRegisterDto() {
	}

	public UserRegisterDto(String name, String username, String email, String city, String password) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.city = city;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
