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
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
   	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp" %>
	
	<div class="container">
		<div class="row"><h3 id="teamName" class="card-title">PROJECT DETAILS</h3></div>
		<div class="row">
			<div class="col-3">
			      
			<div class="card">
				<img src="${pageContext.request.contextPath}/resources/img/team.jpg" class="card-img-top" alt="Card image">
				<div class="card-body">
					<h5 id="projectName" class="card-title"><b>${currentProject.name}</b></h5>
					<p id="ProjectDesc" class="card-text">${currentProject.description}</p>
				</div>
				<ul class="list-group list-group-flush">
					<li id="projectManager" class="list-group-item"><strong>Project Manager</strong> <br/>${currentProject.manager.firstName} ${currentProject.manager.lastName}</li>
					<li id="createdDate" class="list-group-item"><strong>Created Date</strong> <br/><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${currentProject.createdAt}"/></li>
				</ul>
			</div>
			
			</div>
			<div class="col">
				<div class="card" >
					<div class="card-header">
						Tasks
						<button type="button" class="btn btn-sm btn-dark right-float" onclick="window.location.href='../proj/getTaskForm'; return false;">Create Task</button>
					</div>
					<ul class="list-group list-group-flush">
						<c:forEach var="task" items="${currentProject.projectTasks}">
							<li id="task" class="list-group-item">
								<h5><strong>${task.taskTitle}</strong></h5> <!-- Task name -->
								${task.description} <br/> <!-- Task description -->
								<b>Members:</b>
								<c:forEach var="taskMember" items="${task.respondents}">
				                    ${taskMember.firstName} ${taskMember.lastName}<br/> <!-- Task members - multiple olabilir. -->
   				 				</c:forEach>
								<b>Start Date:</b> <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${task.startDate}"/> <br/> <!-- Task start date --> 
								<b>Deadline:</b> <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${task.finishDate}"/> <br/> <!-- Task end date -->
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			
			<div class="col-4">
				<div class="card">
					<div class="card-header">
						Project Members
					</div>
					<ul class="list-group list-group-flush">
						<!-- Burada for ile project memberlar donucek. 
						<li class="list-group-item">Bilgehan Kaya</li>
						-->
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>