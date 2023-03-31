<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Portal - Add Subject</title>
</head>
<body>

<h2>Add Subject</h2>
<form action="LaAdminPortalController" method="post">
	<label>Subject name</label>
	<input type="text" name="subjectName" maxlength="20"><br/>
		
	<jsp:include page="/ListService" flush="true" >
   		<jsp:param name="listOperation" value="View Teacher" />
   	</jsp:include>
	
	<label>Assign Teacher</label>
	<% if(request.getAttribute("listTeacher") != null){ %>
		<select name="teacherId">
			<c:forEach items="${listTeacher}" var="teacher">
				<option value="${teacher.id}">${teacher.name}</option>
			</c:forEach>
	</select><br/>
	<% }
	else{ %>
		<input type="text" disabled="disabled" value="No teacher added."><br/>
	<%} %>
	<input type="submit" value="Add Subject">
	<input type="reset" value="Reset">
	<input type="hidden" name="addOperation" value="Add Subject">
</form><br/>

<a href="home.jsp">Go to home</a><br>

</body>
</html>