<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create</title>
	</head>
<body>
	<h1>Create Team</h1>
	<h3>Hoşgeldin ${currentUser}</h3>
	<form:form action="createTeam" modelAttribute="team" method="POST">
		<table>
			<tbody>
				<tr>
					<td><label>Name</label></td>
					<td><form:input path="name"/></td>
				</tr>
				<tr>
					<td><label>Description</label></td>
					<td><form:input path="description"/></td>
				</tr>
				<tr>
					<td><label>Category</label></td>
					<td><form:input path="category"/></td>
				</tr>
			</tbody>
		</table>
		<div>
			<button type="submit" class="btn btn-success">Save Team</button>
		</div>
	</form:form>		
</body>
</html>