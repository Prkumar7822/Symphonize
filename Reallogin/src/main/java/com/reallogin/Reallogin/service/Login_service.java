package com.reallogin.Reallogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reallogin.Reallogin.exception.MycustomeException;
import com.reallogin.Reallogin.model.Login_model;
import com.reallogin.Reallogin.repository.Login_Repo;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Login_service {

    @Autowired
    private Login_Repo loginRepo;

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private boolean isValidEmail(String username) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public String registerUser(Login_model user) throws MycustomeException {
        if (!isValidEmail(user.getUsername())) {
            throw new MycustomeException("Invalid email");
//        	return "Invalid email";
        }

        Optional<Login_model> existingUser = loginRepo.findByUsername(user.getUsername());

        if(existingUser.isPresent()) {
            throw new MycustomeException("User already exists");
//        	return "User already exists";
        } 
        if(user.getPassword().length()<6) {
        	throw new MycustomeException("Password must be contain 6 places");
        }
        else {
            loginRepo.save(user);
            throw new MycustomeException("User registered succesfully");
//            return "User registered succesful";
        }
    }

    public String loginUser(String username, String password) throws MycustomeException {
        Optional<Login_model> userOpt = loginRepo.findByUsername(username);

        if (!userOpt.isPresent()) {
//            return "User not found!";
        	throw new MycustomeException("User not found");
        }
        
        Login_model user = userOpt.get();

        if (user.getPassword().equals(password)) {
//            return "Login successful!";
            throw new MycustomeException("User not found");
        }
         else {
//            return "Invalid password!";
            throw new MycustomeException("User not found");
        }
        }
    }
