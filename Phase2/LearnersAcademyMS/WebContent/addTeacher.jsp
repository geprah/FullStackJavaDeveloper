<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Portal - Add Teacher</title>
</head>
<body>

<h2>Add Teacher</h2>

<form action="LaAdminPortalController" method="post">
	<label>Teacher's name</label>
	<input type="text" name="teacherName"><br/>
	<input type="submit" value="Add Teacher">
	<input type="reset" value="Reset">
	<input type="hidden" name="addOperation" value="Add Teacher">
</form><br/>

<a href="home.jsp">Go to home</a><br>

</body>
</html>