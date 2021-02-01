<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- Bootstrap CSS -->
    	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	</head>
<body>

	<%@ include file="navbar.jsp" %>

	<div class="container">
	  <div class="row">
	    <div class="col">
	
	      <div class="card">
	        <img src="${pageContext.request.contextPath}/resources/img/default.png" class="card-img-top" alt="Card image">
	        <div class="card-body">
	          <h5 id="userName" class="card-title">${currentUser.firstName} ${currentUser.lastName}</h5>
	          <p id="userDesc" class="card-text">Description about user.</p>
	        </div>
	        <ul class="list-group list-group-flush">
	          <li id="userMail" class="list-group-item"><strong>Mail Address</strong> <br/> ${currentUser.emailAddress}</li>
	          <li id="userPhone" class="list-group-item"><strong>Phone Number</strong> <br/> ${currentUser.phoneNumber}</li>
	        </ul>
	      </div>
	    </div>

	    <div class="col-6">
    	  <h1 class="display-6">TASKS</h1>

			<form:form action="details" method="POST">
				<c:set var="counter" value="1" scope="page"/>
				<c:forEach var="task" items="${currentUser.assignedTasks}">
					<input type="hidden" name="teamId" value="${task.id}"/>
	      			<div class="card text-dark bg-light mb-3" >
						<div class="card-header">Task #${counter}</div>
							<c:set var="counter" value="${counter + 1}" scope="page"/>
							<div class="card-body">
							<h5 class="card-title">${task.taskTitle}</h5>
							<p class="card-text">${task.description}</p>
						</div>
						<div class="card-footer">
						  <small><strong>Due Date</strong></small> <br/>
						  <small id="due-date">${task.finishDate}</small>
						</div>
	    		  	</div>
				</c:forEach>
			</form:form>
	    </div>
	
	    <div class="col">
	      <div class="list-group" style="width: 18rem;">
			<h1 class="display-6">TEAMS</h1>
		      	<c:forEach var="team" items="${currentUser.registeredTeams}">
					<form:form action="${pageContext.request.contextPath}/team/details" method="GET">
						<input type="hidden" name="teamId" value="${team.id}"/>
		      			<button type="submit" class="list-group-item list-group-item-dark list-group-item-action mb-2">${team.name}</button>
					</form:form>
				</c:forEach>
	      	<button type="button" class="btn btn-dark" onclick="window.location.href='team/getForm'; return false;">Create Team</button>
	      </div>
	    </div>
	
	  </div>
	</div>	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>