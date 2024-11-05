package com.First.Trying.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.First.Trying.Model.Student_data;
import com.First.Trying.service.Student_service;
@RestController
@RequestMapping("/Student")
public class Student_controller {
	
	
	@Autowired
	private Student_service stuservice;
	
	
	@PostMapping("/addstudent")
	public String Add(@RequestBody Student_data data) {
		
		stuservice.addstudent(data);
		return  "data is saved succesfully";
	}
	
	
	@GetMapping("/findid/{id}")
	public Optional<Student_data> data(@PathVariable int id){
		
		
		return stuservice.retriveStu(id);
		
	}

	@PutMapping("/update/{id}")
	public String update(@PathVariable Integer id,@RequestBody Student_data data) {
		
		stuservice.updateStu(id,data);
		return "updated";
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletestu(@PathVariable int id) {
		stuservice.deletstu(id);
	}
	

}
