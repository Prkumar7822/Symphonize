package com.reallogin.Reallogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reallogin.Reallogin.model.Login_model;

public interface Login_Repo extends JpaRepository<Login_model, String>{

}
