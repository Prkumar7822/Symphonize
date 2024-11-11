package com.practicedto.dto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicedto.dto.User.User;
import com.practicedto.dto.service.User_service;
import com.practicedto.dto.userdto.User_dto;

@RestController
@RequestMapping("/Dto")
public class User_controller {
	
	@Autowired
	private User_service service;
	
	@PostMapping("/createuser")
	public User_dto Tosave(@RequestBody User user) {
		 
		 return  service.CreateUser(user);
	}
	
	@GetMapping("/geting/{id}")
	public User get(@PathVariable int id ) {
		return service.retrieve(id);
	}
	
	

}
