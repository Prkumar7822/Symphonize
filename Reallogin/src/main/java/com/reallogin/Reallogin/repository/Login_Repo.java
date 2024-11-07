package com.reallogin.Reallogin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reallogin.Reallogin.model.Login_model;
@Repository
public interface Login_Repo extends JpaRepository<Login_model, Long>{
    Optional<Login_model> findByUsername(String username);


}
