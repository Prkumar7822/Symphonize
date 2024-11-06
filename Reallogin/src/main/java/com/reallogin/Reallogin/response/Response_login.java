package com.reallogin.Reallogin.response;

public class Response_login {
	
	
	public String registerUser() {
		return "registered succesfully";
	}
	
	
	public String userExist() {
		return "User already exists";
	}
	
	public String match() {
		return "Login succesful";
	}
	
	public String invalidEmail() {
		return "Invalid emails";
	}

}
