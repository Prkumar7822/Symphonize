package com.practicedto.dto.except;

public class UserNotFoundException extends RuntimeException {
	 public UserNotFoundException(String message) {
	        super(message);
	    }

}
