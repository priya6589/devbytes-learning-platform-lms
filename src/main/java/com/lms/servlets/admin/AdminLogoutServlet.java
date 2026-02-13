package com.lms.servlets.admin;


import com.lms.entities.MessageEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/logout")
public class AdminLogoutServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        try {
            HttpSession session = req.getSession(false);

            if (session != null) {
                session.invalidate();
            }

            Cookie cookie = new Cookie("JSESSIONID", null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            resp.addCookie(cookie);

            // New session for flash message
            HttpSession newSession = req.getSession(true);
            newSession.setAttribute("msg",
                    new MessageEntity(
                            "Logged out successfully",
                            "success",
                            "alert-success"
                    )
            );

            resp.sendRedirect(req.getContextPath()
                    + "/admin/login.jsp");

        } catch (Exception e) {
            e.printStackTrace();

            resp.sendRedirect(req.getContextPath()
                    + "/admin/login.jsp?error=logout");
        }
    }
}
