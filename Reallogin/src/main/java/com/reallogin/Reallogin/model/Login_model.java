package com.reallogin.Reallogin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Login_model {
	@Id
	private String username;
	
	private String password;

	
	
	
	
	public Login_model(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	

	public Login_model() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}}
	
	
	
	
	


	