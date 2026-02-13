<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.lms.entities.MessageEntity" %>
<%@ page  import="com.lms.entities.AdminEntity"%>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" integrity="sha384-4LISF5TTJX/fLmGSxO53rV4miRxdg84mZsxmO8Rx5jGtp/LbrixFETvWa5a6sESd" crossorigin="anonymous">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/admin-common.css" />

</head>

<body>

<%
    AdminEntity admin =
        (AdminEntity) session.getAttribute("currentAdmin");
%>
 <!-- header -->
<%@include file="/admin/partials/header.jsp"%>

 <!-- sidebar -->
<%@include file="/admin/partials/sidebar.jsp"%>

 <!-- main-content -->
<%@include file="/admin/partials/main.jsp"%>

  <div id="loader"></div>

<!-- JS -->
<script src="<%=request.getContextPath()%>/assets/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/admin-common.js"></script>


</body>
</html>
