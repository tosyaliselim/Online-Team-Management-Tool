
<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-5" >
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav me-auto mb-2 mb-lg-0">
        <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
      </div>
       <form:form action="${pageContext.request.contextPath}/logout" method="POST" class="d-flex">
      			<button class="btn btn-outline-info me-2" type="submit">Logout</button>
     		</form:form>
    </div>
  </div>
</nav>
