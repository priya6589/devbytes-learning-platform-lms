package com.lms.daos;

import com.lms.config.ConnectionProvider;
import com.lms.entities.AdminEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {
    private Connection con;

    public AdminDao(){
        this.con = ConnectionProvider.getConnection();
    }

//    1.Admin login by email and password....
    public AdminEntity finByEmail(String email){
        AdminEntity admin = null;
        try{

            String sql = "SELECT * FROM admin_users WHERE email = ? AND deleted_at IS NULL LIMIT 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,email);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                admin = new AdminEntity();
                admin.setFullName(rs.getString("full_name"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
                admin.setCountry(rs.getString("country"));
                admin.setMobileNumber(rs.getString("mobile"));

                return admin;
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong!...please try again later."+e.getMessage());
        }

        return admin;
    }
}
