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
<body class="request">
    <mytags:userstag/>
    <h2 class="thiselement">Thomas Event Event Management System</h2>
    <h3>Welcome to your homepage ${firstname }</h3>
</body>
</html>