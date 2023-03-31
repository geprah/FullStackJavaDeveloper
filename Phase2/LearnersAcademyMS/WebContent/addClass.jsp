<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Portal - Class</title>
</head>
<body>
<h2>Add Class</h2>
<form action="LaAdminPortalController" method="post">
	<label>Class name</label>
	<input type="text" name="className" maxlength="20"><br/>
		
	<jsp:include page="/ListService" flush="true" >
   		<jsp:param name="listOperation" value="View Subject" />
   	</jsp:include>
	
	<label>Assign Subject</label>
	<% if(request.getAttribute("listSubject") != null){ %>
		<select name="classId">
			<c:forEach items="${listSubject}" var="subject">
				<option value="${subject.id}">${subject.name}</option>
			</c:forEach>
	</select><br/>
	<% }
	else{ %>
		<input type="text" disabled="disabled" value="No Subjects added."><br/>
	<%} %>
	<input type="submit" value="Add Class">
	<input type="reset" value="Reset">
	<input type="hidden" name="addOperation" value="Add Class">
	</form><br/>
	
	<a href="home.jsp">Go to home</a><br>
	
</body>
</html>