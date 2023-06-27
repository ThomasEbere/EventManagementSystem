<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/mynewstyle.css" rel="stylesheet">

</head>
<body>
<table>
<tr>
<th>Event Name</th>
<th>Event Description</th>
<th>Request Date</th>
<th>Request Status</th>
</tr>

<c:forEach var="request" items="${requests }">
<tr>
<td>${request.eventName }</td>
<td>${request.eventDescription }</td>
<td>${request.eventStartDate }</td>
<td>${request.status }</td>

</tr>
</c:forEach>
</table>
</body>
</html>