package com.lms.servlets.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/dashboard")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("DashboardServlet HIT");


        req.setAttribute("pageTitle", "Dashboard");
        req.setAttribute("contentPage", "/admin/dashboard.jsp");

        req.getRequestDispatcher("/admin/layout.jsp").forward(req, resp);
    }
}
