package com.customer.Nice.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;

@Entity
public class Customer_Model {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cid;
	
	private String cname;
	
	@Column(unique = true)
	private Long cnumber;
	
	@Column(unique = true)
	private Long cadharno;

	
	public Customer_Model(Long cid, String cname, Long cnumber, Long cadharno) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cnumber = cnumber;
		this.cadharno = cadharno;
	}

	public Customer_Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Long getCnumber() {
		return cnumber;
	}

	public void setCnumber(Long cnumber) {
		this.cnumber = cnumber;
	}

	public Long getCadharno() {
		return cadharno;
	}

	public void setCadharno(Long cadharno) {
		this.cadharno = cadharno;
	}
	
	
	
	
}
