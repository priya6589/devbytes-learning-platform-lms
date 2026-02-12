package com.lms.servlets;

import com.lms.entities.Message;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        try {
            HttpSession session = req.getSession(false);

            if (session != null) {
                session.invalidate();
            }

            // New session for flash message
            HttpSession newSession = req.getSession(true);
            newSession.setAttribute("msg",
                    new Message(
                            "Logged out successfully",
                            "success",
                            "alert-success"
                    )
            );

            resp.sendRedirect(req.getContextPath()
                    + "/frontend/auth/login.jsp");

        } catch (Exception e) {
            e.printStackTrace();

            resp.sendRedirect(req.getContextPath()
                    + "/frontend/auth/login.jsp?error=logout");
        }
    }
}
