package com.reallogin.Reallogin.model1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Register_model {
	
	
	@Id
	private String username1;
	
	private String password;
	
	private String confirmpass;

	
	
	
	
	
	
	public Register_model(String username1, String password, String confirmpass) {
		super();
		this.username1 = username1;
		this.password = password;
		this.confirmpass = confirmpass;
	}
	

	public Register_model() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUsername1() {
		return username1;
	}

	public void setUsername1(String username1) {
		this.username1 = username1;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpass() {
		return confirmpass;
	}

	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}
	
	
	

}
