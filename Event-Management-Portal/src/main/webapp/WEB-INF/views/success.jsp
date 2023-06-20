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
  <nav>
        <ul id="Navigation">
            <a href=""><li class="myhome">Home</li></a>
            <div class="otherlist">
            <a href="" class="active"><li>View Request</li></a>
            <a href="#" class=""><li>Users</li></a>
            <a href="" class=""><li>Logout</li></a>
            </div>
        </ul>
    </nav>
<table>
<tr>
<th>Event Name</th>
<th>Event Description</th>
<th>Request Date</th>
</tr>

<c:forEach var="request" items="${request }">
<tr>
<td>${request.eventName }</td>
<td>${request.eventDescription }</td>
<td>${request.eventStartDate }</td>
<td><a href="request/${request.id}">View Request</a>
</tr>
</c:forEach>
</table>
</body>
</html>