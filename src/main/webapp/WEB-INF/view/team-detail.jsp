<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>List</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	</head>
<body>
	<%@ include file="navbar.jsp" %>


<div class="container">
	<div class="row"><h3 id="teamName" class="card-title">TEAM DETAILS</h3></div>
  <div class="row">
    <div class="col-3">
		<div class="card">
		  <img src="${pageContext.request.contextPath}/resources/img/team.jpg" class="card-img-top" alt="Card image">
		  <div class="card-body">
		    <h5 id="teamName" class="card-title"> ${currentTeam.name}</h5>
		    <p id="teamDesc" class="card-text">${currentTeam.description}</p>
		  </div>
		  <ul class="list-group list-group-flush">
		    <li id="teamCategory" class="list-group-item"><strong>Category</strong> <br/>${currentTeam.category}</li>
		    <li id="createdData" class="list-group-item"><strong>Created Date</strong> <br/><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${currentTeam.createdAt}"/></li>
		  </ul>
		</div>
    </div>
        <!-- 2. kolon -->
<div class="col">

      <!-- Projects için list -->
<div class="card" >
  <div class="card-header">
    Projects
    <button type="button" class="btn btn-sm btn-dark right-float" onclick="window.location.href='../proj/getForm'; return false;">Create Project</button>
  </div>
  <div class="list-group">
   	
     	<c:forEach var="project" items="${currentTeam.teamProjects}">
 			<form:form action="${pageContext.request.contextPath}/proj/details" method="GET">
	 			<input type="hiqden" name="projectId" value="${project.id}"/>
				<button type="submit" class="list-group-item list-group-item-action">${project.name}</button>
			</form:form>
   		</c:forEach>
   	
  </div>
</div>

    </div>
    <div class="col-4">
      

<div class="card">
  <div class="card-header">
    Team Members
    <button type="button" class="btn btn-sm btn-dark right-float">Send Invitation</button>
  </div>
  <ul class="list-group list-group-flush">
	<c:forEach var="member" items="${currentTeam.teamMembers}">
	    <li class="list-group-item">${member.firstName} ${member.lastName}</li>
	</c:forEach>
	</ul>

</div>
</div>
</div>
</div>

	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>