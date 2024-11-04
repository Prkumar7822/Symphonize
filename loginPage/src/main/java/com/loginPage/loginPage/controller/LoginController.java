package com.loginPage.loginPage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginPage.loginPage.Model.User;
import com.loginPage.loginPage.service.LoginService;
@RestController
@RequestMapping("/loginPage")
public class LoginController {
	
	
	private  LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
		this.loginService = loginService;
    }

  
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        loginService.registerUser(user);
        return "User Registered Successfully";
    }
    
   
    @GetMapping("/getallusers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = loginService.findAllUsers();
        return new ResponseEntity<List<User>>(users,HttpStatus.OK);
    }

    // Delete user by ID
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id ) {
        loginService.deleteUser(id);
        return ResponseEntity.ok("User Deleted Successfully");
    }

    // Update user information
    @PutMapping("/updateuser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User user) {
        User updatedUser = loginService.updateUser(id,user);
        return ResponseEntity.ok(updatedUser);
    }

    // Count total users
    @GetMapping("/countusers")
    public ResponseEntity<Long> countUsers() {
        long userCount = loginService.countUsers();
        return ResponseEntity.ok(userCount);
    }
    
    }


