package com.blog.config;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
    private static Connection con;

    public static Connection getConnection(){
      try{
          if(con == null){
          //1. Driver class load.
          Class.forName("com.mysql.jdbc.Driver");
         //2.Create a connection.
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog","root", "root");
          }
      }catch(Exception ex){
          ex.printStackTrace();
          System.out.println("Something went wrong...please try again later.");
      }
        return con;
    }
}
