package com.dxc.hms.model;

 

import javax.persistence.Column;

 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name="PATIENT")

 

public class Patient {
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
    private String Username;
    private String Password;
    
    @Column(name="PASSWORD")
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    private String emailid;
    private String phonenumber;
    private String address;
    private int age;
    private String gender;
    
    @Column(name="USERNAME")
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    @Column(name="EMAILID")
    public String getEmailid() {
        return emailid;
    }
    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
    @Column(name="PHONENUMBER")

 

    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    @Column(name="ADDRESS")

 

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name="AGE")

 

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Column(name="GENDER")

 

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
}
