package com.lms.entities;

import com.lms.enums.Gender;

import java.sql.Timestamp;

public class AdminEntity extends AbstractEntity {

    private String fullName;
    private String email;
    private String password;
    private String mobileNumber;
    private String country;
    private Gender gender;


    //    Constructors...
    public AdminEntity() {
    }

    public AdminEntity(int id, String uuid, int version, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
        super(id, uuid, version, createdAt, updatedAt, deletedAt);
    }

    public AdminEntity(int id, String uuid, int version, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt, String fullName, Gender gender, String country, String mobileNumber, String password, String email) {
        super(id, uuid, version, createdAt, updatedAt, deletedAt);
        this.fullName = fullName;
        this.gender = gender;
        this.country = country;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.email = email;
    }

    public AdminEntity(String fullName, String email, String password, String mobileNumber, String country, Gender gender) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.country = country;
        this.gender = gender;
    }

//    Getters & Setters....


    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getCountry() {
        return country;
    }

    public Gender getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
