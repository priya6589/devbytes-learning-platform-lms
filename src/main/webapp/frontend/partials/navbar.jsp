<nav class="navbar navbar-expand-lg navbar-dark bg-black fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand d-flex align-items-center" href="<%=request.getContextPath()%>/">
           <img
               src="<%=request.getContextPath()%>/assets/images/logo.png"
               alt="DevBytes Logo"
               class="img-fluid"
               style="max-height:40px;"
           >
       </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/"><span class="fa fa-home"></span> Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><span class="fa fa-graduation-cap"></span> Courses</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#"><span class="fa fa-book"></span> Notes</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="#"><span class="fa fa-newspaper-o"></span> Blogs</a>
        </li>
       <li class="nav-item">
         <a class="nav-link" href="#"><span class="fa fa-phone"></span> Contact</a>
       </li>
       <li class="nav-item">
         <a class="nav-link" href="#"><span class="fa fa-external-link"></span> About us</a>
       </li>
      </ul>
    </div>
  </div>
</nav>