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
	<h2>Team Manager: ${currentUser.firstName} ${currentUser.lastName}</h2>
	<br>
	<hr>
	<br>
	<h3>Team Details</h3>
	<table class="content-table">
	    <thead>
			<tr>
				<th>Team Name</th>
				<th>Description</th>
				<th>Category</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${currentTeam.name}</td>
				<td>${currentTeam.description}</td>
				<td>${currentTeam.category}</td>
			</tr>
		</tbody>
	</table>
	<h3>Team Member Info</h3>
	<table class="content-table">
	    <thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Address</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${currentTeam.teamMembers}">
				<tr>
					<td>${member.firstName}</td>
					<td>${member.lastName}</td>
					<td>${member.emailAddress}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>