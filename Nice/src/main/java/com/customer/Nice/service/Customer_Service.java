package com.customer.Nice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.customer.Nice.Model.Customer_Model;
import com.customer.Nice.dto.Customer_dto;
import com.customer.Nice.exception.Mycustomexception;
import com.customer.Nice.repository.Customer_repo;
@Service
@Validated
public class Customer_Service {
	
	@Autowired
	private Customer_repo repo;
	
	public ResponseEntity<Customer_dto> cust_to_dto(Customer_Model customer) {
		
		Customer_dto dto=new Customer_dto();
		dto.setCid(customer.getCid());
		dto.setCname(customer.getCname());
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	public ResponseEntity<Customer_dto> Register(Customer_Model customer) {
		
		Customer_Model obj=new Customer_Model();
	    String cnumber = customer.getCnumber();

		if(cnumber.length()<10) {
			throw new Mycustomexception("Phone number should contain 10 digits");
		}
	    String cadharno = customer.getCadharno();

		if(cadharno.length()<12) {
			throw new Mycustomexception("Adhar number should contain 12 digits");
		}
		
		repo.save(customer);
		
		return cust_to_dto(customer);
		
	}

	public ResponseEntity<String> Delete(Long cid) {
		if(repo.existsById(cid)) {
			repo.deleteById(cid);
			return new ResponseEntity<>("Customer deleted succesfully",HttpStatus.OK);
		}
		else {
			throw new Mycustomexception("Customer with "+cid + " is not present");
		}
		
		
	}

	public ResponseEntity<Customer_Model> Update(Long cid,Customer_Model model) {
		
		 Optional<Customer_Model> opt = repo.findById(cid);
	        
	        if (opt.isPresent()) {
	            Customer_Model existingCustomer = opt.get();
	            existingCustomer.setCname(model.getCname());
	            existingCustomer.setCnumber(model.getCnumber());
	            existingCustomer.setCadharno(model.getCadharno());
	            
	            Customer_Model updatedCustomer = repo.save(existingCustomer);
	            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	        } else {
	            throw new Mycustomexception("Customer with ID " + cid + " not found");
	        }
		
	}
	
	
	public ResponseEntity<Customer_dto> Getcustomer(long cid) {
	    Optional<Customer_Model> obj = repo.findById(cid);

	    if (obj.isPresent()) {
	        Customer_Model model = obj.get();
	        Customer_dto dto = new Customer_dto();
	        dto.setCid(model.getCid());
	        dto.setCname(model.getCname());
	        return new ResponseEntity<>(dto, HttpStatus.OK);
	    } else {
	        throw new Mycustomexception("Cid is not present");
	    }
	}
	
	
	public ResponseEntity<List<Customer_dto>> getcustomers() {
	    List<Customer_Model> customers = repo.findAll();
	    
	    List<Customer_dto> customerDtos = customers.stream().map(customer -> {
	        Customer_dto dto = new Customer_dto();
	        dto.setCid(customer.getCid());
	        dto.setCname(customer.getCname());
	        return dto;
	    }).collect(Collectors.toList());
	    
	    return new ResponseEntity<>(customerDtos, HttpStatus.OK);
	}
	

}
