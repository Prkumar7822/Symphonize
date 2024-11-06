package com.reallogin.Reallogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reallogin.Reallogin.model.Login_model;
import com.reallogin.Reallogin.service.Login_service;

@RestController
@RequestMapping("Login")
public class Login_controller {

    @Autowired
    private Login_service userService;

    @PostMapping("/register")
    public String register(@RequestBody Login_model user) {
        userService.registerUser(user);
        return "User registered successfully!";  
    }

    @PostMapping("/login")
    public String login(@RequestBody Login_model user) {
        return userService.loginUser(user.getUsername(),user.getPassword());
    }
}
