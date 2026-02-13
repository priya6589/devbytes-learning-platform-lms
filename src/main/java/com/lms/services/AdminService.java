package com.lms.services;

import com.lms.config.ConnectionProvider;
import com.lms.daos.AdminDao;
import com.lms.entities.AdminEntity;
import com.lms.utils.PasswordUtil;

import java.sql.Connection;

import static com.lms.utils.HelperUtil.isEmpty;

public class AdminService {
    private Connection con;
    private AdminDao adminDao;

    public AdminService(){
        this.con = ConnectionProvider.getConnection();
        this.adminDao = new AdminDao();
    }

//    1.Admin Login....
    public AdminEntity login(String email,String password){
        AdminEntity admin = null;
        try {
            if(isEmpty(email) || isEmpty(password)){
                throw new IllegalArgumentException("Email or password empty");
            }

            admin = adminDao.finByEmail(email);

            if(admin == null){
                return null; // admin not found.
            }

            if(!PasswordUtil.verify(password,admin.getPassword())){
                return null;//Password not matched.
            }

            return admin;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong!...please try again later."+e.getMessage());
        }
        return admin;
    }
}
