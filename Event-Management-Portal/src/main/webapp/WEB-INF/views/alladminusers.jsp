<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            <%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/mynewstyle.css" rel="stylesheet">
</head>
<body>
<mytags:adminnav1/>

<h3 class="adminlist">This is a list of all the admin users</h3>
<table class="admintable">
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
</tr>

<c:forEach var="data" items="${user }">
<tr>
<td>${data.firstName }</td>
<td>${data.lastName }</td>
<td>${data.email }</td>
</tr>
</c:forEach>
</table>
</body>
</html>