<%
    request.setAttribute("pageTitle", "Users");
    request.setAttribute("contentPage",
            "/admin/user/index.jsp");

    RequestDispatcher rd =
        request.getRequestDispatcher("/admin/layout.jsp");
    rd.forward(request, response);
%>