package com.customer.Nice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hotel_Model {
	@Id
	private int cid;
	
	private String type;
	
	private int days;
	
	
	private long cost;


	public Hotel_Model(int cid, String type, int days, long cost) {
		super();
		this.cid = cid;
		this.type = type;
		this.days = days;
		this.cost = cost;
	}


	public Hotel_Model() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}


	public long getCost() {
		return cost;
	}


	public void setCost(long cost) {
		this.cost = cost;
	}

}