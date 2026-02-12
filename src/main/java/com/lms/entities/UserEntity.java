package com.lms.entities;

import com.lms.enums.Gender;

import java.sql.Timestamp;

public class UserEntity extends AbstractEntity {

    private String fullName;
    private String email;
    private String password;
    private String mobileNumber;
    private String country;
    private String qualification;
    private Gender gender;

    public UserEntity() {
    }

    public UserEntity(String fullName, String email, String password, String mobileNumber, String country, String qualification, Gender gender) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.country = country;
        this.qualification = qualification;
        this.gender = gender;
    }

    public UserEntity(String fullName, String email, String password, String mobileNumber, String country, String qualification) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.country = country;
        this.qualification = qualification;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
