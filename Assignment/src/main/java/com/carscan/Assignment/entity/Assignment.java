package com.carscan.Assignment.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Assignment {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userID")
	private Long id;
	
	@Column(name = "firstName")
private String fname;
	
	@Column(name = "lastName")
private String lname;
	
	@Column(name = "Dob")
private LocalDate dob;
	
	@Column(name = "City")
private String city;
	
	@Column(name = "mobileNo")
private Long mobileno;
	
	
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public Long getMobileno() {
	return mobileno;
}
public void setMobileno(Long mobileno) {
	this.mobileno = mobileno;
}
}
