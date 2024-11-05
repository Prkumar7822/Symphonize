package com.First.Trying.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.First.Trying.Model.Student_data;
import com.First.Trying.Repository.Student_Repo;
@Service
public class Student_service {
	
	
	
	@Autowired()
	private Student_Repo repo;

	public void addstudent(Student_data data) {
		
		
		repo.save(data);
		
	}

	public Optional<Student_data> retriveStu(int id) {
		
		return repo.findById(id);
		
	}

	public void updateStu( int id, Student_data data) {
		
		Student_data exist=repo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
		
		exist.setName(data.getName());
		exist.setGrade(data.getGrade());
		repo.save(exist);
	}

	public void deletstu( int id) {
		repo.deleteById(id);
	}

}
