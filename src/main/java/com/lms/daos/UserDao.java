package com.lms.daos;
import com.lms.config.ConnectionProvider;
import com.lms.entities.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    private Connection con;

    public UserDao(){
        this.con = ConnectionProvider.getConnection();
    }

    //1.Save method to insert into db:
    public boolean insertUser(UserEntity user){
        boolean flag = false;
     try{
      //         user --> DB...
         String query = "INSERT INTO users (uuid,version,full_name,email,password,mobile,country,qualification)\n" +
                 "VALUES(?,?,?,?,?,?,?,?)";
         PreparedStatement ps = this.con.prepareStatement(query);
         ps.setString(1, user.getUuid());
         ps.setInt(2, user.getVersion());
         ps.setString(3, user.getFullName());
         ps.setString(4, user.getEmail());
         ps.setString(5, user.getPassword());
         ps.setString(6, user.getMobileNumber());
         ps.setString(7, user.getCountry());
         ps.setString(8, user.getQualification());

         ps.executeUpdate();
         ps.close();

         flag = true;


     } catch (Exception e) {
         e.printStackTrace();
         System.out.println("Something went wrong!...please try again later.");
     }

     return flag;
    }

    //2.Find the data with email & password from DB:
    public UserEntity findByEmail(String email){
       UserEntity user = null;
        try{

            String sql = "SELECT * FROM users WHERE email = ? AND deleted_at IS NULL LIMIT 1";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,email);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                user = new UserEntity();

                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setMobileNumber(rs.getString("mobile"));
                user.setCountry(rs.getString("country"));
                user.setQualification(rs.getString("qualification"));

                return user;
            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong!...please try again later."+e.getMessage());
        }

        return user;
    }
}
