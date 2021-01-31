<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>   
<html>   
	<head>  
		<meta name="viewport" content="width=device-width, initial-scale=1">  
		<title> Login Page </title> 
		<!-- Bootstrap CSS -->
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>    
	<body>
	
		<div class="container mt-4">

			<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" class="col-lg-6 offset-lg-3" >
	    		<div class="form-group">
			        <div class="col-xs-15">
			            <div>	
	           				<c:if test="${param.error != null}">
								<div class="alert alert-danger col-xs-offset-1 col-xs-10">
									Incorrect username or password.
								</div>
							</c:if>
							<c:if test="${param.logout != null}">        
								<div class="alert alert-success col-xs-offset-1 col-xs-10">
									You have been logged out.
								</div>
					   		</c:if>  
			            </div>
			        </div>
			    </div>
				<div class="row justify-content-center">
					<div class="form-group">
						<label for="uname">Username:</label>
						<input type="text" name="username"  class="form-control mb-2" placeholder="Enter username">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label>
						<input type="password" name="password" class="form-control mb-2" placeholder="Enter password">
					</div>
	
					<div class="row justify-content-center">
						<button type="submit" class="btn btn-primary btn-dark btn-block mb-4">Sign in</button>
					</div>
				</div> 
			</form:form>
		</div>
		    
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>   
	</body>     
</html>  






