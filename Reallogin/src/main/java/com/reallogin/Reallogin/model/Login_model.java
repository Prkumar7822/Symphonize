package com.reallogin.Reallogin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
@Entity
public class Login_model {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @NotBlank(message = "Username is required")
	    @Email(message = "Username must be a valid email")
	    @Column(unique = true)
	    private String username;

	    @NotBlank(message = "Password is required")
	    @NotBlank(message = "Password is mandatory")
	    private String password;

	    // Constructors
	    public Login_model() {
	    }

	    public Login_model(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
}
	
	
	