package com.practicedto.dto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicedto.dto.User.User;
import com.practicedto.dto.except.UserNotFoundException;
import com.practicedto.dto.repository.User_repo;
import com.practicedto.dto.userdto.User_dto;

@Service
public class User_service {
	
	
	
	@Autowired
	private User_repo repo;
	
	public User_dto Usertodto(User user) {
		User_dto dto= new User_dto();
		
		
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		return dto;
	}
	
//	public User_dto dtotouser(User_dto dto) {
//		
//		
//		User user=new User();
//		user.setId(dto.getId());
//		user.setName(dto.getName());
//		user.setEmail(dto.getEmail());
//		
//		
//		return user;
//	}
//	
	
	public User_dto CreateUser(User user) {
		
		user =repo.save(user);
		return Usertodto(user);
	}
	
	
	public User retrieve(int id) {
		Optional<User> user = repo.findById(id);
		if(user.isPresent()) {
		return user.get();
		}
		else {
			throw new UserNotFoundException("user not found");
		}
	}
	
	
	

}
