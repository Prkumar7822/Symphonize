package com.customer.Nice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.Nice.service.Hotel_service;

@RestController
@RequestMapping("/Hotel")
public class Hotel_Customer_Controller {

	
	
	@Autowired
	private Hotel_service service;
	
	@PostMapping("/selecttype/{cid}/{type}/{days}")
	public String selectType(@PathVariable int cid, @PathVariable String type, @PathVariable int days) {
	return service.selectroom(cid,type,days);
	
}
}