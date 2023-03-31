<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Classes</title>
</head>
<body>

<h3>All Classes</h3>

<jsp:include page="/ListService" flush="true" >
	<jsp:param name="listOperation" value="View Class" />
</jsp:include>
 
<% if(request.getAttribute("listClass") != null){ %>  	
<table>
  <tr>
    <th>Class ID</th>
    <th>Class section</th>
    <th>Assigned Subject ID</th>
  </tr>
  <c:forEach items="${listClass}" var="cclass">
  	<tr>
    	<td>${cclass.id}</td>
    	<td>${cclass.classSection}</td>
    	<td>${cclass.subjectId}</td>
    </tr>
  </c:forEach>
  </table><br/>
<% }
else{ %>
<h4>No class added</h4>
<%} %>

</body>
</html>