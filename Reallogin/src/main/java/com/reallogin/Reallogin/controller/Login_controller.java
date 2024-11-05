package com.reallogin.Reallogin.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reallogin.Reallogin.model.Login_model;
import com.reallogin.Reallogin.model1.Register_model;
import com.reallogin.Reallogin.service.Login_service;

@RestController
@RequestMapping("Login")
public class Login_controller {
	
	
	@Autowired
	private Login_service service;
	
	
	@PostMapping("/register")
	public void RegisterUser(@RequestBody Register_model reg) {
		service.register(reg);
	}
	
	public void LoginUser(@RequestBody Login_model mod) {
		service.Login(mod);
	}
	
	
	
	

}
