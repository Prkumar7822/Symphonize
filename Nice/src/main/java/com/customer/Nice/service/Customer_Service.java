package com.customer.Nice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.Nice.Model.Customer_Model;
import com.customer.Nice.dto.Customer_dto;
import com.customer.Nice.repository.Customer_repo;
@Service
public class Customer_Service {
	
	@Autowired
	private Customer_repo repo;
	
	public Customer_dto cust_to_dto(Customer_Model customer) {
		
		Customer_dto dto=new Customer_dto();
		dto.setCid(customer.getCid());
		dto.setCname(customer.getCname());
		
		return dto;
	}
	
	public Customer_dto Register(Customer_Model customer) {
		
		repo.save(customer);
		
		return cust_to_dto(customer);
	}

	public String Delete(Long cid) {
		
		repo.deleteById(cid);
		return "Customer Deleted succesfully";
	}

	public Customer_Model Update(Long cid,Customer_Model model) {
		
		Optional<Customer_Model> opt= repo.findById(cid);
		Customer_Model mod=new Customer_Model();
		
		if(opt.isPresent()) {
		
		mod.setCname(model.getCname());
		mod.setCnumber(model.getCnumber());
		mod.setCadharno(model.getCadharno());
		}
		return mod;
		
		
	}
	
	

}
