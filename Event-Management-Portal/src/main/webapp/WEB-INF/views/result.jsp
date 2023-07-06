<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${error}">${error }</c:if>
  <h3 style='color: green;'>Success!</h3>
  <div>Id: <span '${id}' /></div>
  <div>Status: <span '${status}' /></div>
  <div>Charge id.: <span '${chargeId}' /></div>
  <div>Balance transaction id.: <span '${balance_transaction}' /></div>
<a href='/checkout.html'>Checkout again</a>
</body>
</html>