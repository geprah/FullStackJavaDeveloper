<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Subjects</title>
</head>
<body>

<h3>All Subjects</h3>

<jsp:include page="/ListService" flush="true" >
	<jsp:param name="listOperation" value="View Subject" />
</jsp:include>
 
<% if(request.getAttribute("listSubject") != null){ %>  	
<table>
  <tr>
    <th>Subject ID</th>
    <th>Subject name</th>
    <th>Assigned Teacher ID</th>
  </tr>
  <c:forEach items="${listSubject}" var="subject">
  	<tr>
    	<td>${subject.id}</td>
    	<td>${subject.name}</td>
    	<td>${subject.teacherId}</td>
    </tr>
  </c:forEach>
  </table><br/>
<% }
else{ %>
<h4>No Subjects added</h4>
<%} %>

</body>
</html>