package com.lms.servlets;

import com.lms.config.ConnectionProvider;
import com.lms.entities.Message;
import com.lms.entities.UserEntity;
import com.lms.services.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        Connection con = ConnectionProvider.getConnection();
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            UserEntity user = userService.login(email, password);

            HttpSession session = req.getSession();
            if(user != null){
                session.setAttribute("currentUser", user);
                session.setAttribute("msg",
                        new Message("Login successful","success","alert-success")
                );
                resp.sendRedirect(req.getContextPath() + "/frontend/index.jsp");

            } else {
                session.setAttribute("msg",new Message("Invalid credentials","error",""));

                resp.sendRedirect(req.getContextPath()
                        + "/frontend/auth/login.jsp?error=invalid");

            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong!...please try again later."+e.getMessage());
            resp.sendRedirect(req.getContextPath()
                    + "/frontend/auth/login.jsp?error=server");
        }
    }
}
