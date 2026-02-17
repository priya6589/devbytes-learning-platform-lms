<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.lms.entities.AdminEntity" %>

<%
    AdminEntity admin =
        (AdminEntity) session.getAttribute("currentAdmin");
%>

<!DOCTYPE html>
<html>
<head>
    <title><%= request.getAttribute("pageTitle") %></title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/admin-common.css" />
</head>

<body>

<!-- HEADER -->
<%@include file="/admin/partials/header.jsp"%>

<!-- SIDEBAR -->
<%@include file="/admin/partials/sidebar.jsp"%>

<!-- MAIN CONTENT -->
<<!-- MAIN CONTENT -->
 <main class="main-content p-4">

 <%
     String content = (String) request.getAttribute("contentPage");
     if (content != null) {
         RequestDispatcher rd = request.getRequestDispatcher(content);
         rd.include(request, response);
     }
 %>

 </main>


<div id="loader"></div>

<script src="<%=request.getContextPath()%>/assets/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/admin-common.js"></script>

</body>
</html>
