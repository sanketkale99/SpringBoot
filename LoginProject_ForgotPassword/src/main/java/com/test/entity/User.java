package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="userapp", uniqueConstraints = @UniqueConstraint(columnNames = "Email") )
public class User //implements UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Username")
	private String username;
	
	@Column(name = "Email")
	private String email; 
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "Password")
	private String password;

	public User() {
		
	}

	public User(Long id, String name, String username, String email, String city, 
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.city = city;
		this.password = password;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	
	
}
