<%@page contentType="text/html" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>
  <header>
    <title>Login page</title>
    <%-- css --%>
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" />
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css" />

  </header>

  <body> <%--Navbar--%>
      <%@include file="/frontend/partials/navbar.jsp" %>
        <%--Login page content--%>
          <main class="min-vh-100 d-flex align-items-center position-relative bg-dark text-white hero-banner">
            <!-- Particles -->
            <div id="particles-js">
            </div>
            <div class="container position-relative" style="z-index:2">
              <div class="row align-items-center">
                <!-- LEFT SIDE -->
                <div class="col-md-5 text-center mb-4 mb-md-0">
                  <h1 class="fw-bold display-5">DevBytes</h1>
                  <p class="text-danger fs-4">Turning Code Into Careers</p>
                  <img src="<%=request.getContextPath()%>/assets/images/logo.png" class="img-fluid mb-3" width="180">
                </div>
                <!-- CREATIVE SEPARATOR -->
                <div class="col-md-1 d-none d-md-flex justify-content-center">
                  <div class="creative-divider"> <span></span> <span></span> <span></span> </div>
                </div> <!-- RIGHT SIDE -->
                <div class="col-md-5">
                  <div class="card bg-dark border-danger shadow-lg">
                    <div class="card-body p-4">
                      <h4 class="text-center mb-4">Login</h4>
                      <form id="loginForm" novalidate>
                        <div class="mb-3"> <input type="email" class="form-control bg-transparent text-white"
                            name="email" placeholder="Email"> </div>
                        <div class="mb-3"> <input type="password" class="form-control bg-transparent text-white"
                            name="password" placeholder="Password"> </div> <button type="submit"
                          class="btn btn-danger w-100">Login</button>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </main> <%-- js --%>
            <script src="https://cdn.jsdelivr.net/npm/particles.js@2.0.0/particles.min.js"></script>
            <script src="<%=request.getContextPath()%>/assets/js/jquery.js" type="text/javascript"></script>
            <script src="<%=request.getContextPath()%>/assets/js/bootstrap.bundle.min.js" type="text/javascript"></script>
            <script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js" type="text/javascript"></script>
            <script src="<%=request.getContextPath()%>/assets/js/custom-particle.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
            <script src="<%=request.getContextPath()%>/assets/js/custom-validation.js"></script>
  </body>

  </html>