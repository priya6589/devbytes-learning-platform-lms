<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Register | DevBytes</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/common.css"/>
</head>

<body>

<%@include file="/frontend/partials/navbar.jsp"%>

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

<h4 class="text-center mb-3">Create Account</h4>

<div class="progress mb-4" style="height:4px">
<div class="progress-bar bg-danger" id="formProgress" style="width:50%"></div>
</div>

<form id="registerForm" novalidate>

<!-- STEP 1 -->
<div class="form-step active">
<div class="mb-3">
<input type="text" class="form-control bg-transparent text-white" name="fullName" placeholder="Full Name">
</div>

<div class="mb-3">
<input type="email" class="form-control bg-transparent text-white" name="email" placeholder="Email">
</div>

<div class="mb-3">
<input type="password" class="form-control bg-transparent text-white" name="password" placeholder="Password">
</div>

<button type="button" class="btn btn-danger w-100" id="nextStep">
Next →
</button>

</div>

<!-- STEP 2 -->
<div class="form-step">
<div class="mb-3">
<input type="text" class="form-control bg-transparent text-white" name="mobileNumber" placeholder="Mobile Number">
</div>
<div class="mb-3">
<input type="text" class="form-control bg-transparent text-white" name="city" placeholder="City">
</div>

<div class="mb-3">
<input type="text" class="form-control bg-transparent text-white" name="qualification" placeholder="Qualification">
</div>

<div class="d-flex gap-2">
<button type="button" class="btn btn-outline-light w-50" id="prevStep">← Back</button>
<button type="submit" class="btn btn-danger w-50">Register</button>
</div>

</div>

</form>

</div>
</div>

</div>

</div>
</div>

</main>

<script src="https://cdn.jsdelivr.net/npm/particles.js@2.0.0/particles.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/custom-particle.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/common.js"></script>
<script src="<%=request.getContextPath()%>/assets/js/custom-validation.js"></script>

</body>
</html>
