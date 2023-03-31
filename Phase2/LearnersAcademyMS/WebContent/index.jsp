<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Portal - Learner's Academy</title>
</head>
<body>

<h2>Admin Portal</h2>
<h3>By George Prah</h3>
<h4>george.prah@vodafone.com</h4>
<br>
<br>
<h4>Login</h4>
<form action="LaAdminPortalController" method="post">
<label>User name:</label>
<input type="text" name="userName" required></input>
<br>
<label>Password:</label>
<input type="password" name="passWord" required></input>
<br>
<input type="submit" value="Login"/>
<input type="reset" value="Reset"/>
<input type="hidden" name="addOperation" value="Login">
</form>
</body>
</html>