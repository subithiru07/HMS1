package com.dxc.hms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DOCTOR")

public class Doctor 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;

	}
	@Column(name="CONT")
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Column(name="date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String date;
	private String emailid;
	private String phonenumber;
	private String department;
	private String availabletiming;
	private String gender;
	private String name;
	private String password;
	
	@Column(name="Password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="Name")
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Column(name="Email")
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
@Column(name="Phone number")
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
@Column(name="Department")
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
@Column(name="Available Timing")
public String getAvailabletiming() {
	return availabletiming;
}
public void setAvailabletiming(String availabletiming) {
	this.availabletiming = availabletiming;
}
@Column(name="Gender")
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}


}