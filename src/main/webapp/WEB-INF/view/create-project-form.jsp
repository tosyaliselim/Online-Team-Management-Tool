<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>OTMT - Create Project</title>
    <meta charset="UTF-8"/>
    <!-- Bootstrap CSS -->
    	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<%@ include file="navbar.jsp" %>

	<div class="container">


<form:form action="${pageContext.request.contextPath}/proj/create" method="POST" modelAttribute="project">
  <div class="mb-3">
    <label for="projectNameLabel" class="form-label">Project Title*</label>
    <form:input type="text" path="name" class="form-control mb-2" placeholder="Software Project" aria-label="default input example"></form:input>
  </div>
<div class="mb-3">
  <label for="teamDescLabel" class="form-label">Description*</label>
  <form:textarea path="description" type="text" class="form-control" id="descTextArea" placeholder="Description for the project" rows="3"></form:textarea>
</div>
  <div class="form-group">
    <label for="managerDropdown">Select a manager for the project:</label>
    <form:select class="form-control"  path="manager">
        <c:forEach var="user" items="${teamMembers}">
            <form:option label="${user.firstName} ${user.lastName}" value="${user.userName}"/>
        </c:forEach>
    </form:select><br>
  </div>
  <p></p>
  <button type="submit" class="btn btn-primary btn-dark">Create Project</button>
</form:form>
</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
	
	
</body>
</html>