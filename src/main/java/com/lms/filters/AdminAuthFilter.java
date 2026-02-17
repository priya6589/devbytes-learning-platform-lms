package com.lms.filters;

import com.lms.entities.AdminEntity;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminAuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String contextPath = req.getContextPath();
        String requestURI = req.getRequestURI();
        String path = requestURI.substring(contextPath.length());

        HttpSession session = req.getSession(false);
        AdminEntity admin = null;

        if (session != null) {
            admin = (AdminEntity) session.getAttribute("currentAdmin");
        }

        boolean isLoggedIn = (admin != null);

        boolean isLoginPage = path.equals("/admin/login.jsp");
        boolean isLoginServlet = path.equals("/admin/login");

        boolean isStaticResource =
                path.startsWith("/assets/") ||
                        path.contains("/partials/") ||
                        path.endsWith(".css") ||
                        path.endsWith(".js") ||
                        path.endsWith(".png") ||
                        path.endsWith(".jpg") ||
                        path.endsWith(".jpeg") ||
                        path.endsWith(".gif") ||
                        path.endsWith(".woff") ||
                        path.endsWith(".woff2");

        if (isStaticResource) {
            chain.doFilter(request, response);
            return;
        }

        // Not logged in
        if (!isLoggedIn && !(isLoginPage || isLoginServlet)) {
            resp.sendRedirect(contextPath + "/admin/login.jsp");
            return;
        }

        // Logged in and opening login page
        if (isLoggedIn && (isLoginPage || isLoginServlet)) {
            resp.sendRedirect(contextPath + "/admin/dashboard");
            return;
        }

        chain.doFilter(request, response);
    }
}

