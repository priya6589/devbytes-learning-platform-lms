package com.lms.filters;

import com.lms.entities.UserEntity;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter("/frontend/*")
public class UserAuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req  = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        try {
            String contextPath = req.getContextPath();
            String requestURI  = req.getRequestURI();
            String path = requestURI.substring(contextPath.length());

            HttpSession session = req.getSession(false);
            UserEntity user = null;

            if (session != null) {
                Object obj = session.getAttribute("currentUser");
                if (obj instanceof UserEntity) {
                    user = (UserEntity) obj;
                }
            }

            boolean isLoggedIn = (user != null);

            // PUBLIC PAGES
            boolean isLoginPage       = path.equals("/frontend/auth/login.jsp");
            boolean isRegisterPage    = path.equals("/frontend/auth/register.jsp");
            boolean isLoginServlet    = path.equals("/login");
            boolean isRegisterServlet = path.equals("/register");

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

            // Allow static files
            if (isStaticResource) {
                chain.doFilter(request, response);
                return;
            }

            // If logged in and trying login/register → redirect home
            if (isLoggedIn &&
                    (isLoginPage || isRegisterPage ||
                            isLoginServlet || isRegisterServlet)) {

                res.sendRedirect(contextPath + "/frontend/index.jsp");
                return;
            }

            // If not logged in and accessing protected page
            if (!isLoggedIn &&
                    !(isLoginPage || isRegisterPage ||
                            isLoginServlet || isRegisterServlet)) {

                res.sendRedirect(contextPath + "/frontend/auth/login.jsp");
                return;
            }

            chain.doFilter(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            res.sendRedirect(req.getContextPath()
                    + "/frontend/auth/login.jsp?error=auth");
        }
    }
}
