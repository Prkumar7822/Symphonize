package com.reallogin.Reallogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.reallogin.Reallogin.model.Login_model;
import com.reallogin.Reallogin.model1.Register_model;
import com.reallogin.Reallogin.repository.Login_Repo;
import com.reallogin.Reallogin.repository1.login_repo1;

@Service
public class Login_service {
	
	@Autowired
	private login_repo1 repo;
	
	@Autowired
	private Login_Repo repo1;
	public void register(Register_model register) {
		repo.save(register);
	}
	
	public void Login(Login_model model) {
		
		repo1.save(model);
		
	}
	
	
	public boolean check(Register_model model,Login_model model1) {
		
		
		
		return true;
			
	}
	
}
