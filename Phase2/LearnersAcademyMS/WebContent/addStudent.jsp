<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student - Admin Portal</title>
</head>
<body>
<h2>Add Student</h2>
<form action="LaAdminPortalController" method="post">
	<label>Class name</label>
	<input type="text" name="studentName" maxlength="20"><br/>
		
	<jsp:include page="/ListService" flush="true" >
   		<jsp:param name="listOperation" value="View Class" />
   	</jsp:include>
	
	<label>Assign Class</label>
	<% if(request.getAttribute("listClass") != null){ %>
		<select name="studentId">
			<c:forEach items="${listClass}" var="cclass">
				<option value="${cclass.id}">${cclass.classSection}</option>
			</c:forEach>
	</select><br/>
	<% }
	else{ %>
		<input type="text" disabled="disabled" value="No Classes added."><br/>
	<%} %>
	<input type="submit" value="Add Student">
	<input type="reset" value="Reset">
	<input type="hidden" name="addOperation" value="Add Student">
	</form><br/>
	
	<a href="home.jsp">Go to home</a><br>
	
</body>
</html>