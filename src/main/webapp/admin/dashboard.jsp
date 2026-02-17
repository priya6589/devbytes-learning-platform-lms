<%@ page import="com.lms.entities.AdminEntity" %>

<%
    AdminEntity admin =
        (AdminEntity) session.getAttribute("currentAdmin");
%>

<%@include file="/admin/partials/main.jsp"%>

