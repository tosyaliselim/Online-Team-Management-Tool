<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>   
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Login Page </title>  
<style>   
body {  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: gray;  
}  
button {   
       background-color: #4CAF50;   
       width: 100%;  
        color: orange;   
        padding: 15px;   
        margin: 10px 0px;   
        border: none;   
        cursor: pointer;   
         }   

 input[type=text], input[type=password] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;   
    }  
 button:hover {   
        opacity: 0.7;   
    }   
     
 .container {   
        padding: 25px;   
        background-color: lightblue;
        width: 50%;
		margin: 0px auto;
    }
 .banner {
	padding: 25px;   
	width: 50%;
	margin: 0px auto;
 }
</style>   
</head>    
<body>
	<h1 class="banner">Login Form</h1> 
    <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
        <div class="container">
            <label>Username : </label>   
            <input type="text" name="username" >
            <label>Password : </label>   
            <input type="password" name="password" > 
            <button type="submit">Login</button>     
        </div>   
    </form:form>     
</body>     
</html>  