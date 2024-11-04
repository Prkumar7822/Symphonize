package com.loginPage.loginPage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginPage.loginPage.Model.User;
import com.loginPage.loginPage.repository.UserRepository;


@Service
public class LoginService {

	
	@Autowired
    private  UserRepository userRepository;

	
	    public void registerUser(User user) {
	        userRepository.save(user);
	    }

	   

	    // Find user by user ID
	    public Optional<User> findUserById(Long userId) {
	        return userRepository.findById(userId);
	    }

	    // Retrieve all users
	    public List<User> findAllUsers() {
	        return userRepository.findAll();
	    }

	    // Delete user by ID
	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }

	    // Update user information (for example)
	    public User updateUser(Long id,User user) {
	    	User existinguser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
	    	existinguser.setUserId(user.getUserId());
	    	existinguser.setPassword(user.getPassword());
	        return userRepository.save(existinguser); // Assuming the user ID is set in the user object
	    }

	    // Count total users
	    public long countUsers() {
	        return userRepository.count();
	    }
	}

