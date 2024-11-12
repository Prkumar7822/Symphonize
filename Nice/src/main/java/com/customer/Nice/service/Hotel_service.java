package com.customer.Nice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.Nice.Model.Hotel_Model;
import com.customer.Nice.hrepo.Hotel_reposit;

@Service
public class Hotel_service {

	@Autowired
	private Hotel_reposit reposit;
	
	
	HashMap<String,Integer> obj=new HashMap();
	
	 public Hotel_service() {
	        obj.put("suite", 2000);  
	        obj.put("deluxe", 1500);  
	    }
	
	public String selectroom(int cid,String type,int days) {
		 if (obj.containsKey(type)) {
	            int price = obj.get(type);
	            price=price*days;
	            Hotel_Model obj1=new Hotel_Model();
	            obj1.setCid( cid);
	            obj1.setType(type);
	            obj1.setDays(days);
	            obj1.setCost(price);
	            
	            reposit.save(obj1);
	            return "Room is given. Room type: " + type + ", Price: " + price;
	        } else {
	            return "Room type not available";
	        }
		
	}
	
	
	
}
