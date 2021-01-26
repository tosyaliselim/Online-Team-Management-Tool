<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

	    <!-- Bootstrap CSS -->
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
		<title>OTMT - Create Team</title>
		
	</head>
<body>
	
	<%@ include file="navbar.jsp" %>
	
	<div class="container">
	<form:form action="create" modelAttribute="team" method="POST">
	  <div class="mb-3">
	    <label for="teamNameLabel" class="form-label">Team Name*</label>
	    <form:input path="name" class="form-control mb-2" type="text" placeholder="Software Team" aria-label="default input example" />
	  </div>
	<div class="mb-3">
	  <label for="teamDescLabel" class="form-label">Description*</label>
	  <form:textarea  path="description" class="form-control" id="descTextArea" rows="3" />
	</div>
	  <div class="mb-3">
	    <label for="teamNameLabel" class="form-label">Select a category:</label>
	    <form:select path="category" class="form-control" id="sel1">
		      <option>Back-End Development</option>
		      <option>Front-End Development</option>
		      <option>Mobile Development</option>
		      <option>Testing</option>
	    </form:select>
	  </div>
		  <p></p>
		  <button type="submit" class="btn btn-primary btn-dark">Create Team</button>
		</form:form>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
		
</body>
</html>
