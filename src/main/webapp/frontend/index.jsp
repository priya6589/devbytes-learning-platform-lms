<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.lms.entities.UserEntity" %>
<%@ page import="com.lms.entities.MessageEntity"%>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard | DevBytes</title>

    <!-- CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css"/>
</head>

<body class="bg-dark text-white">

<%
    UserEntity u = (UserEntity) session.getAttribute("currentUser");

    // AUTH GUARD
    if (u == null) {
        response.sendRedirect(request.getContextPath() + "/frontend/auth/login.jsp");
        return;
    }
%>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-black border-bottom border-danger">
    <div class="container">
        <a class="navbar-brand fw-bold" href="#">
            <i class="fa-solid fa-code text-danger"></i> DevBytes
        </a>

        <div class="ms-auto d-flex align-items-center gap-3">
            <span class="text-light">
                👋 Welcome, <strong><%= u.getFullName() %></strong>
            </span>

            <a href="<%=request.getContextPath()%>/logout"
               class="btn btn-sm btn-outline-danger">
                <i class="fa-solid fa-right-from-bracket"></i> Logout
            </a>
        </div>
    </div>
</nav>

<!-- DASHBOARD -->
<main class="container py-5">

    <!-- FLASH MESSAGE -->
    <%
       MessageEntity msg = (MessageEntity) session.getAttribute("msg");
        if (msg != null) {
    %>
    <div class="alert <%= msg.getCssClass() %> auth-alert text-center fade show">
        <%= msg.getContent() %>
    </div>
    <%
            session.removeAttribute("msg");
        }
    %>

    <div class="row g-4">

        <!-- PROFILE CARD -->
        <div class="col-md-4">
            <div class="card bg-black border-danger shadow">
                <div class="card-body text-center">
                    <i class="fa-solid fa-user-circle fa-5x text-danger mb-3"></i>
                    <h5 class="fw-bold"><%= u.getFullName() %></h5>
                    <p class="text-muted mb-1"><%= u.getEmail() %></p>
                    <p class="text-muted"><%= u.getCountry() %></p>
                </div>
            </div>
        </div>

        <!-- DASHBOARD STATS -->
        <div class="col-md-8">
            <div class="row g-3">

                <div class="col-md-6">
                    <div class="card bg-black border-danger shadow">
                        <div class="card-body">
                            <h6 class="text-danger">
                                <i class="fa-solid fa-book"></i> Courses Enrolled
                            </h6>
                            <h2 class="fw-bold">0</h2>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="card bg-black border-danger shadow">
                        <div class="card-body">
                            <h6 class="text-danger">
                                <i class="fa-solid fa-chart-line"></i> Progress
                            </h6>
                            <h2 class="fw-bold">0%</h2>
                        </div>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="card bg-black border-danger shadow">
                        <div class="card-body">
                            <h6 class="text-danger">
                                <i class="fa-solid fa-bullhorn"></i> Announcements
                            </h6>
                            <p class="text-muted mb-0">
                                No announcements yet 🚀
                            </p>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>
</main>

<!-- JS -->
<script src="<%=request.getContextPath()%>/assets/js/bootstrap.bundle.min.js"></script>
<script>
            setTimeout(() => {
                const alert = document.querySelector('.auth-alert');
                if (alert) {
                    alert.classList.remove('show');
                    alert.classList.add('fade');
                    setTimeout(() => alert.remove(), 500);
                }
            }, 3000);
</script>

</body>
</html>
