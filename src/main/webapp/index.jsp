<html>

<head>
  <title>DevBytes Technologies | Home</title>

  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css" />
</head>

<body>

  <%@include file="/frontend/partials/navbar.jsp" %>

    <div class="position-relative overflow-hidden bg-dark text-white min-vh-75 py-5 hero-banner">

      <div id="particles-js"></div>

      <div class="container text-center py-5 position-relative hero-content" style="z-index:2">

        <h1 class="display-4 fw-bold">DevBytes Technologies</h1>

        <p class="fs-4 text-danger">Turning Code Into Careers</p>

        <p class="lead mb-4">
          Explore courses, notes, and blogs designed for modern developers.
        </p>

        <div class="d-flex justify-content-center gap-3">

          <a href="<%=request.getContextPath()%>/frontend/auth/register.jsp" class="btn btn-outline-danger btn-lg">
            <span class="fa fa-user-plus"></span> Register
          </a>

          <a href="<%=request.getContextPath()%>/frontend/auth/login.jsp" class="btn btn-outline-danger btn-lg">
            <span class="fa fa-user-circle-o fa-spin"></span> Login
          </a>

        </div>

      </div>
    </div>

      <%@include file="/frontend/courses-section.jsp" %>

    <script src="https://cdn.jsdelivr.net/npm/particles.js@2.0.0/particles.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/custom-particle.js"></script>



</body>

</html>