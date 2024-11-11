package com.practicedto.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practicedto.dto.User.User;
@Repository
public interface User_repo extends JpaRepository<User, Integer>{
	
}
