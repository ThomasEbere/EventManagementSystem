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
<p class="email-sent">Email to make payment has been sent to the client. Please click <a href="userhomepage">here</a> to return to the homepage</p>
</body>
</html>