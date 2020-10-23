package com.dxc.hms.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="CONFIRMEDAPPOINTMENT")
public class ConfirmedAppointment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	@Column(name="ID")
	public long getId() {
		return Id;
	}
	
	public void setId(long id) {
		Id = id;
	}
	private String Name;
	@Override
	public String toString() {
		return "ConfirmedAppointment [Id=" + Id + ", Name=" + Name + ", DoctorName=" + DoctorName + ", time=" + time
				+ ", date=" + date + ", illness=" + illness + ", specialist=" + specialist + ", status=" + status + "]";
	}
	private String DoctorName;
	private String time;
	private String date;
	private String illness;
	private String specialist;
	private String status;
	@Column(name="NAME")
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	@Column(name="DOCTORNAME")
	public String getDoctorName() {
		return DoctorName;
	}
	public void setDoctorName(String doctorName) {
		DoctorName = doctorName;
	}
	@Column(name="TIME")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Column(name="DATE")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Column(name="ILLNESS")
	public String getIllness() {
		return illness;
	}
	public void setIllness(String illness) {
		this.illness = illness;
	}
	@Column(name="SPECIALIST")
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
