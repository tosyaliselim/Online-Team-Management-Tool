<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>List</title>
	</head>
<body>
	<table class="content-table">
	    <thead>
			<tr>
				<th>name</th>
				<th>description</th>
				<th>category</th>
				<th>manager</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="team" items="${teams}">
				<tr>
					<td>${team.name}</td>
					<td>${team.description}</td>
					<td>${team.category}</td>
					<td>${team.manager.firstName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>