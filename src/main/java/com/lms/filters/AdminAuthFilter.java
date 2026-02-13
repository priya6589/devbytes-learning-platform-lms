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

        try {
            String contextPath = req.getContextPath();
            String requestURI = req.getRequestURI();

            // Remove context path for easier matching
            String path = requestURI.substring(contextPath.length());

            HttpSession session = req.getSession(false);
            AdminEntity admin = null;

            if (session != null) {
                Object obj = session.getAttribute("currentAdmin");
                if (obj instanceof AdminEntity) {
                    admin = (AdminEntity) obj;
                }
            }

            boolean isLoggedIn = (admin != null);

            // Allowed URLs without login
            boolean isLoginPage = path.equals("/admin/login.jsp");
            boolean isLoginServlet = path.equals("/admin/login");

            // Allow static resources
            boolean isStaticResource =
                    path.startsWith("/assets/") ||
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

            // Case 1: Logged in + trying login page
            if (isLoggedIn && (isLoginPage || isLoginServlet)) {
                resp.sendRedirect(contextPath + "/admin/dashboard.jsp");
                return;
            }

            // Case 2: Not logged in + accessing protected page
            if (!isLoggedIn && !(isLoginPage || isLoginServlet)) {
                resp.sendRedirect(contextPath + "/admin/login.jsp");
                return;
            }

            // Continue normally
            chain.doFilter(request, response);

        } catch (Exception e) {
            e.printStackTrace();

            // Safe fallback redirect
            resp.sendRedirect(req.getContextPath() + "/admin/login.jsp?error=auth");
        }
    }
}
