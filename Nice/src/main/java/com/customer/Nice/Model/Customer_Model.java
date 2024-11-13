package com.customer.Nice.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
public class Customer_Model {

	
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cid;
	
	private String cname;
	
    @Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
    	@Column(unique = true)
	private String cnumber;
	
    @Size(min = 12, max = 12, message = "Adhar number must be exactly 12 digits")
	@Column(unique = true)
	private String cadharno;
    

	public Customer_Model(Long cid, String cname,
			@Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits") @Digits(integer = 10, fraction = 0, message = "Phone number must be numeric and 10 digits long") String cnumber,
			@Pattern(regexp = "^\\d{12}$", message = "Aadhaar number must be 12 digits") @Digits(integer = 12, fraction = 0, message = "Aadhaar number must be numeric and 12 digits long") String cadharno) {
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

	public String getCnumber() {
		return cnumber;
	}

	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}

	public String getCadharno() {
		return cadharno;
	}

	public void setCadharno(String cadharno) {
		this.cadharno = cadharno;
	}
    

}