package com.loginPage.loginPage.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginPage.loginPage.Model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 
}


