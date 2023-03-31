<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Class Report</title>
</head>
<body>

<h3>Class Report</h3>

<jsp:include page="/ListService" flush="true" >
	<jsp:param name="listOperation" value="View Class Report" />
</jsp:include>
 
<% if(request.getAttribute("listClassReport") != null){ %>  	
<table>
  <tr>
    <th>Class ID</th>
    <th>Class Section</th>
    <th>Teacher Name</th>
    <th>Subject Name</th>
    <th>Student Name</th>
  </tr>
  <c:forEach items="${listClassReport}" var="classReport">
  	<tr>
    	<td>${classReport.id}</td>
    	<td>${classReport.classSection}</td>
     	<td>${classReport.teacherName}</td>
     	<td>${classReport.subjectName}</td> 
     	<td>${classReport.studentName}</td> 
    </tr>
  </c:forEach>
  </table><br/>
<% }
else{ %>
<h4>No class added</h4>
<%} %>

<br/>
<a href="home.jsp">Go to home</a>
</body>
</html>