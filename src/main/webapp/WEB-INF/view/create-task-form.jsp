<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>OTMT - Create Task</title>
    <meta charset="UTF-8"/>
    <!-- Bootstrap CSS -->
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
   	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<%@ include file="navbar.jsp" %>

	<div class="container">
		<form:form action="${pageContext.request.contextPath}/proj/createTask" method="POST" modelAttribute="task">
			<div class="mb-3">
				<label for="taskNameLabel" class="form-label">Task Title</label>
				<form:input path="taskTitle" class="form-control mb-2" type="text" placeholder="Bootstrap Design" aria-label="default input example"></form:input>
			</div>
			
			<div class="mb-3">
				<label for="taskDescLabel" class="form-label">Description</label>
				<form:textarea path="description" class="form-control" id="descTextArea" placeholder="Description for the task" rows="3"></form:textarea>
			</div>
			<!-- 
			<div class="mb-3">
			  <label for="example-date-input" class="form-label">Start Date</label>
		      <form:input path="startDate" class="form-control" type="date"></form:input>
			</div>
			
			<div class="mb-3">
			  <label for="example-date-input" class="form-label">End Date</label>
		      <form:input path="finishDate" class="form-control" type="date"></form:input>
			</div>
 			 -->
			<label for="taskRespondentLabel" class="form-label">Respondents:</label>
			<div class="form-check form-check-inline">
				<c:forEach var="teamMember" items="${teamMembers}">
                    <form:checkbox path="respondents"  
                    			 class="form-check-input"
                                 label="${teamMember.firstName} ${teamMember.lastName}"
                                 value="${teamMember.userName}"/>
   				 </c:forEach>
			</div>
			
			<br/>
			<button type="submit" class="btn btn-primary btn-dark mt-3">Create Task</button>
		</form:form>
	</div>

</body>
</html>