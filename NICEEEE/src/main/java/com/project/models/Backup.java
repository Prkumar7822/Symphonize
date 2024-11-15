package com.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Backup {
	
	@Id
	private Long hotelid;
	private String hotelname;
	private String hotelAddress;
	private String hoteltype;
	private Double costperDay;
	
	private Integer roomBill;
	private Double foodBill;
	public Long getHotelid() {
		return hotelid;
	}
	public void setHotelid(Long hotelid) {
		this.hotelid = hotelid;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public String getHoteltype() {
		return hoteltype;
	}
	public void setHoteltype(String hoteltype) {
		this.hoteltype = hoteltype;
	}
	public Double getCostperDay() {
		return costperDay;
	}
	public void setCostperDay(Double costperDay) {
		this.costperDay = costperDay;
	}
	public Integer getRoomBill() {
		return roomBill;
	}
	public void setRoomBill(Integer roomBill) {
		this.roomBill = roomBill;
	}
	public Double getFoodBill() {
		return foodBill;
	}
	public void setFoodBill(Double foodBill) {
		this.foodBill = foodBill;
	}
	public Backup(Long hotelid, String hotelname, String hotelAddress, String hoteltype, Double costperDay,
			Integer roomBill, Double foodBill) {
		super();
		this.hotelid = hotelid;
		this.hotelname = hotelname;
		this.hotelAddress = hotelAddress;
		this.hoteltype = hoteltype;
		this.costperDay = costperDay;
		this.roomBill = roomBill;
		this.foodBill = foodBill;
	}
	public Backup() {
		super();
		// TODO Auto-generated constructor stub
	}


}
