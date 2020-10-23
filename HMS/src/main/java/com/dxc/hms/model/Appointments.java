package com.dxc.hms.model;

 

import javax.persistence.Column;


 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name="APPOINTMENTS")
public class Appointments {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="ID")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Column(name="TIME")
    private String time;
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
    @Column(name="SPECIALIST")
    public String getSpecialist() {
        return specialist;
    }
    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }

    @Column(name="ILLNESS")
    public String getIllness() {
        return illness;
    }
    public void setIllness(String illness) {
        this.illness = illness;
    }
    @Column(name="PATIENTNAME")
    public String getPatientname() {
        return patientname;
    }
    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }
    private String date;
    private String specialist;
    
    private String illness;
    private String patientname;

 


}
