<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.lms.entities.MessageEntity" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login page</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/admin-common.css" />
</head>

<body class="d-flex justify-content-center align-items-center vh-100 bg-light">

<div class="container">
   <div class="row justify-content-center">
      <div class="col-md-5">
           <div class="card shadow">
                <div class="card-header text-center fw-bold">
                   Admin Login
                </div>

                <div class="card-body text-center">
                     <form action="<%=request.getContextPath()%>/admin/login" method="POST">
                          <div class="mb-3">
                             <input type="email" class="form-control bg-transparent" name="email" placeholder="Email">
                          </div>

                          <div class="mb-3">
                             <input type="password" class="form-control bg-transparent" name="password" placeholder="Password">
                          </div>

                          <button type="submit" class="btn btn-primary w-100">Login</button>
                     </form>
                </div>
           </div>
      </div>
   </div>
</div>


<!-- JS -->
<script src="<%=request.getContextPath()%>/assets/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/bootstrap.bundle.min.js"></script>


</body>
</html>
