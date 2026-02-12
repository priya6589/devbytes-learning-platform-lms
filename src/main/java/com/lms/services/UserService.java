package com.lms.services;

import com.lms.config.ConnectionProvider;
import com.lms.daos.UserDao;
import com.lms.entities.UserEntity;
import com.lms.utils.HelperUtil;
import com.lms.utils.PasswordUtil;

import java.sql.Connection;

public class UserService {
    private Connection con;
    private UserDao userDao;

    public UserService(){
        this.con = ConnectionProvider.getConnection();
        this.userDao = new UserDao();
    }


    // ================= REGISTER =================

    public boolean register(UserEntity user){
        try {

            validate(user);

            // AUTO FIELDS
            user.setUuid(HelperUtil.generateUUID());
            user.setVersion(HelperUtil.initialVersion());

            // HASH PASSWORD
            user.setPassword(PasswordUtil.hash(user.getPassword()));
            return userDao.insertUser(user);

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong!...please try again later.");
            return false;
        }
    }

    // ================= VALIDATION =================

    private void validate(UserEntity user){
        if(user == null)
            throw new IllegalArgumentException("User is null");

        if(user.getFullName() == null || user.getFullName().isEmpty())
            throw new IllegalArgumentException("Full name is required");

        if(user.getEmail() == null || user.getEmail().isEmpty())
            throw new IllegalArgumentException("Email is required");

        if(user.getPassword() == null || user.getPassword().isEmpty())
            throw new IllegalArgumentException("Password is required");

        if(user.getMobileNumber() == null || user.getMobileNumber().isEmpty())
            throw new IllegalArgumentException("Mobile number is required");

        if(user.getCountry() == null || user.getCountry().isEmpty())
            throw new IllegalArgumentException("Country is required");

        if(user.getQualification() == null || user.getQualification().isEmpty())
            throw new IllegalArgumentException("Qualification is required");
    }

    private boolean isEmpty(String s){
        return s == null || s.trim().isEmpty();
    }

    public UserEntity login(String email, String password) {
        UserEntity user = null;
        try {
            if (isEmpty(email) || isEmpty(password)) {
                throw new IllegalArgumentException("Email or password empty");
            }

             user = userDao.findByEmail(email);

            if (user == null) {
                return null; // user not found
            }

            if (!PasswordUtil.verify(password, user.getPassword())) {
                return null; // wrong password
            }

            return user;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong!...please try again later."+e.getMessage());
        }
        return user;
    }




}
