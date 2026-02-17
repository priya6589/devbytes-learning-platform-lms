package com.lms.servlets.admin;

import com.lms.config.ConnectionProvider;
import com.lms.entities.AdminEntity;
import com.lms.entities.MessageEntity;
import com.lms.services.AdminService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
    private AdminService adminService;

    @Override
    public void init(){
        Connection con = ConnectionProvider.getConnection();
        adminService = new AdminService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            AdminEntity admin = adminService.login(email, password);

            HttpSession session = req.getSession();
            if(admin != null){
                session.setAttribute("currentAdmin", admin);
                session.setAttribute("msg",
                        new MessageEntity("Login successful","success","alert-success")
                );
                resp.sendRedirect(req.getContextPath() + "/admin/dashboard");

            } else {
                session.setAttribute("msg",new MessageEntity("Invalid credentials","error",""));

                resp.sendRedirect(req.getContextPath()
                        + "/admin/login.jsp?error=invalid");

            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong!...please try again later."+e.getMessage());
            resp.sendRedirect(req.getContextPath()
                    + "/admin/login.jsp?error=server");
        }
    }
}
