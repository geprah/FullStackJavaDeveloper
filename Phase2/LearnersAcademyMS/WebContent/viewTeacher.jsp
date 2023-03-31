<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Teachers - Admin Portal</title>
</head>
<body>

<h3>All Teachers</h3>

<jsp:include page="/ListService" flush="true" >
	<jsp:param name="listOperation" value="View Teacher" />
</jsp:include>
 
<% if(request.getAttribute("listTeacher") != null){ %>  	
<table>
  <tr>
    <th>Teacher ID</th>
    <th>Teacher's name</th>
  </tr>
  <c:forEach items="${listTeacher}" var="teacher">
  	<tr>
    	<td>${teacher.id}</td>
    	<td>${teacher.name}</td>
    </tr>
  </c:forEach>
  </table><br/>
<% }
else{ %>
<h4>No Teachers added</h4>
<%} %>

</body>
</html>