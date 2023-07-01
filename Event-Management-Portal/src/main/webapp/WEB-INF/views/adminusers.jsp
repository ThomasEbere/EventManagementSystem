<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="admincontrol">
<div><a href ="signup">Create a new Admin User</a></div>
<div><a href ="adminusers">view all admin users</a></div>
<div><a href ="allregularusers">View all regular users</a></div>
</div>
</body>
</html>