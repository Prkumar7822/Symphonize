package com.reallogin.Reallogin;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.reallogin.Reallogin.exception.MycustomeException;
import com.reallogin.Reallogin.model.Login_model;
import com.reallogin.Reallogin.repository.Login_Repo;
import com.reallogin.Reallogin.service.Login_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

public class Login_serviceTest {

    @Mock
    private Login_Repo loginRepo;

  
    @InjectMocks
    private Login_service loginService;

    private Login_model user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new Login_model();
        user.setUsername("testUser@gmail.com");
        user.setPassword("password123");
    }

    @Test
    public void testRegisterUser_UserAlreadyExists() throws MycustomeException {
         when(loginRepo.findByUsername(user.getUsername())).thenReturn(Optional.of(user));

         MycustomeException exception = assertThrows(MycustomeException.class, () -> {
            loginService.registerUser(user);
        });
        assertEquals("User already exists", exception.getMessage());
    }

    @Test
    public void testRegisterUser_PasswordTooShort() throws MycustomeException {
    	
         user.setPassword("short");
        when(loginRepo.findByUsername(user.getUsername())).thenReturn(Optional.empty());

         MycustomeException exception = assertThrows(MycustomeException.class, () -> {
            loginService.registerUser(user);
        });
        assertEquals("Password must be contain 6 places", exception.getMessage());
    }

    @Test
    public void testRegisterUser_SuccessfulRegistration() throws MycustomeException {

    	when(loginRepo.findByUsername(user.getUsername())).thenReturn(Optional.empty());  
        when(loginRepo.save(user)).thenReturn(user);  
         String result = loginService.registerUser(user);

         assertEquals("User registered succesfully", result);   
    }


    @Test
    public void testLoginUser_UserNotFound() throws MycustomeException {
         when(loginRepo.findByUsername(user.getUsername())).thenReturn(Optional.empty());

         MycustomeException exception = assertThrows(MycustomeException.class, () -> {
            loginService.loginUser(user.getUsername(), user.getPassword());
        });
        assertEquals("User not found", exception.getMessage());
    }

    @Test
    public void testLoginUser_InvalidPassword() throws MycustomeException {
         Login_model existingUser = new Login_model();
        existingUser.setUsername("testUser@gmail.com");
        existingUser.setPassword("password123");
        when(loginRepo.findByUsername(user.getUsername())).thenReturn(Optional.of(existingUser));

         MycustomeException exception = assertThrows(MycustomeException.class, () -> {
            loginService.loginUser(user.getUsername(), "wrongPassword");
        });
        assertEquals("invalid password", exception.getMessage());
    }

    @Test
    public void testLoginUser_SuccessfulLogin() throws MycustomeException {
         Login_model existingUser = new Login_model();
        existingUser.setUsername("testUser@gmail.com");
        existingUser.setPassword("password123");
        when(loginRepo.findByUsername(user.getUsername())).thenReturn(Optional.of(existingUser));

         String result = loginService.loginUser("testUser@gmail.com", "password123");

         assertEquals("Login Succesfull", result);
    }
}
