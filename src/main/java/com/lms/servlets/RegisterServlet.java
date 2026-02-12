package com.lms.servlets;

import com.lms.config.ConnectionProvider;
import com.lms.entities.UserEntity;
import com.lms.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private Connection con;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        this.con = ConnectionProvider.getConnection();
        userService = new UserService();
    }

//    public RegisterServlet(Connection con){
//        this.con = con;
//        this.userService = new UserService(con);
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
     try{

         UserEntity user = new UserEntity();
         user.setFullName(request.getParameter("fullName"));
         user.setEmail(request.getParameter("email"));
         user.setPassword(request.getParameter("password"));
         user.setMobileNumber(request.getParameter("mobileNumber"));
         user.setCountry(request.getParameter("country"));
         user.setQualification(request.getParameter("qualification"));

         boolean saved = userService.register(user);

         if(saved){
             response.sendRedirect(request.getContextPath() + "/frontend/auth/login.jsp?success=registered");
         }else{
             response.sendRedirect(request.getContextPath() + "/frontend/auth/register.jsp?error=failed");
         }


     } catch (Exception e) {
         e.printStackTrace();
         System.out.println("Something went wrong!...please try again later.");
         response.sendRedirect(request.getContextPath() + "/frontend/auth/register.jsp?error=failed");


     }
    }
}
