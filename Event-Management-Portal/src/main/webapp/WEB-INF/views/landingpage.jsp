<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/mynewstyle.css" rel="stylesheet">
</head>
<body class="request">
    <nav class="client">
        <a href="http://" class="my-home"><li>Home</li></a>
        <div class="element-div">
            <a href="submitrequest"><li>Submit Requests</li></a>
            <a href="viewSubmittedRequests"><li>View Submitted Request</li></a>
            <a href="logout"><li>Logout</li></a>
        </div>
    </nav>
    <h2 class="thiselement">Event Management System</h2>
    <h3>Welcome to your homepage ${firstname }</h3>
</body>
</html>