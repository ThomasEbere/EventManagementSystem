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
<c:if test="${message=='Paid'}"> Yes</c:if>
<h3 class="payment-h3">This is the estimated cost for your Event</h3>
<div class="payment-div">
<h3>Please click on the "pay with Card" button to make payment</h3>
<form action="/Event-Management-Portal/charge/${id }" method="post" id ="checkout-form">
    <input type="hidden" value="${amount}" name="amount">
    <label for="">Price: ${amount}</label>
    <script
            src='https://checkout.stripe.com/checkout.js'
            class='stripe-button'
            data-key='${stripePublicKey}'
        data-amount='${amount *100}'
         data-currency='${currency}'
            data-name='EMS'
            data-description='Payment Checkout'
            data-image
                    ='https://www.baeldung.com/wp-content/themes/baeldung/favicon/android-chrome-192x192.png'
            data-locale='auto'
            data-zip-code='false'>
    </script>
</form>
</div>
</body>
</html>