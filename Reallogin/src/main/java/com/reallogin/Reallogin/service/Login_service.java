package com.reallogin.Reallogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reallogin.Reallogin.model.Login_model;
import com.reallogin.Reallogin.repository.Login_Repo;
import com.reallogin.Reallogin.response.Response_login;

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

    public String registerUser(Login_model user) {
        if (!isValidEmail(user.getUsername())) {
            return "Invalid username: Must be a valid email address.";
        }

        Optional<Login_model> existingUser = loginRepo.findByUsername(user.getUsername());

        if (existingUser.isPresent()) {
            return "User already exists!";
        } else {
            loginRepo.save(user);
            return "User registered successfully!";
        }
    }

    public String loginUser(String username, String password) {
        Optional<Login_model> userOpt = loginRepo.findByUsername(username);

        if (!userOpt.isPresent()) {
            return "User not found!";
        }
        
        Login_model user = userOpt.get();

        if (user.getPassword().equals(password)) {
            return "Login successful!";
        } else {
            return "Invalid password!";
        }
    }
}
