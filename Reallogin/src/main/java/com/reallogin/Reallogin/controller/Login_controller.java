package com.reallogin.Reallogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reallogin.Reallogin.exception.MycustomeException;
import com.reallogin.Reallogin.model.Login_model;
import com.reallogin.Reallogin.service.Login_service;

import jakarta.validation.Valid;

@RestController
@RequestMapping("Login")
public class Login_controller {

    @Autowired
    private Login_service userService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody Login_model user) throws MycustomeException {
       return  userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Login_model user) throws MycustomeException {
        return userService.loginUser(user.getUsername(),user.getPassword());
    }
}
