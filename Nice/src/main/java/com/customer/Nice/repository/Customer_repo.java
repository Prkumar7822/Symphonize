package com.customer.Nice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.Nice.Model.Customer_Model;
@Repository
public interface Customer_repo extends JpaRepository<Customer_Model, Long>{

}
