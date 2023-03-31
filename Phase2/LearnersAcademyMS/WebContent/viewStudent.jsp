<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Students</title>
</head>
<body>

<h3>All Students</h3>

<jsp:include page="/ListService" flush="true" >
	<jsp:param name="listOperation" value="View Student" />
</jsp:include>
 
<% if(request.getAttribute("listStudent") != null){ %>  	
<table>
  <tr>
    <th>Student ID</th>
    <th>Student name</th>
    <th>Assigned Class ID</th>
  </tr>
  <c:forEach items="${listStudent}" var="student">
  	<tr>
    	<td>${student.id}</td>
    	<td>${student.name}</td>
    	<td>${student.classId}</td>
    </tr>
  </c:forEach>
  </table><br/>
<% }
else{ %>
<h4>No class added</h4>
<%} %>

</body>
</html>