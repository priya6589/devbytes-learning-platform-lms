<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="com.lms.entities.MessageEntity" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login page</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css" />
</head>

<body>

<%@include file="/frontend/partials/navbar.jsp" %>

<main class="min-vh-100 d-flex align-items-center position-relative bg-dark text-white hero-banner">

    <div id="particles-js"></div>

    <div class="container position-relative" style="z-index:2">
        <div class="row align-items-center">

            <!-- LEFT -->
            <div class="col-md-5 text-center mb-4 mb-md-0">
                <h1 class="fw-bold display-5">DevBytes</h1>
                <p class="text-danger fs-4">Turning Code Into Careers</p>
                <img src="<%=request.getContextPath()%>/assets/images/logo.png" width="180">
            </div>

            <div class="col-md-1 d-none d-md-flex justify-content-center">
                <div class="creative-divider"><span></span><span></span><span></span></div>
            </div>

            <!-- RIGHT -->
            <div class="col-md-5">
                <div class="card bg-dark border-danger shadow-lg">
                    <div class="card-body p-4">
                        <%
                            MessageEntity msg = (MessageEntity) session.getAttribute("msg");
                            if (msg != null) {
                        %>
                        <div class="alert <%= msg.getType() %> text-center auth-alert fade show">
                            <div class="auth-alert-icon">
                                <i class="fa fa-exclamation-circle"></i>
                            </div>
                            <div class="auth-alert-text">
                                <%= msg.getContent() %>
                            </div>
                        </div>
                        <%
                                session.removeAttribute("msg");
                            }
                        %>

                        <h4 class="text-center mb-4">Login</h4>
                        <form action="<%=request.getContextPath()%>/login" method="POST">
                            <div class="mb-3">
                                <input type="email" class="form-control bg-transparent text-white"
                                       name="email" placeholder="Email">
                            </div>

                            <div class="mb-3">
                                <input type="password" class="form-control bg-transparent text-white"
                                       name="password" placeholder="Password">
                            </div>

                            <button class="btn btn-danger w-100">Login</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</main>

<!-- JS -->
<script src="https://cdn.jsdelivr.net/npm/particles.js@2.0.0/particles.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/custom-particle.js"></script>
<script>
    setTimeout(() => {
        const alert = document.querySelector('.auth-alert');
        if (alert) alert.style.display = 'none';
    }, 3000);
</script>


</body>
</html>
