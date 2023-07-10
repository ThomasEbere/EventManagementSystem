<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/mynewstyle.css" rel="stylesheet">
</head>
<body>
<h3 class="cost-page">Please enter an estimate cost</h3>

<div class="payment-form">
<form action="/Event-Management-Portal/generatepayment">
<label for="amount">Amount</label>
<input type="number" name="amount"/>
<input type="hidden" value ="${requestid}" name="id"/>
<input type="hidden" value ="${email}" name="email"/>
<input type="submit" value="submit">
</form>
</div>
</body>
</html>