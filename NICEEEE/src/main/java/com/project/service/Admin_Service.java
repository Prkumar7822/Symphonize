package com.project.service;

import com.project.models.Hotel_Model;

public interface Admin_Service {

	public  String getRoomBill(Long cid);
	public String getFoodBill(Long cid);
	public Double getTotalBill(Long cid);
	public String AmountPaid(Long cid, String cardnumber, String cvv);
}
