<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/charge" method="post" id ="checkout-form">
    <input type="hidden" value="${amount}" name="amount">
    <label for="">Price: ${amount/100}</label>
    <script
            src='https://checkout.stripe.com/checkout.js'
            class='stripe-button'
            data-key='${stripePublicKey}'
        data-amount='${amount}'
         data-currency='${currency}'
            data-name='Baeldung'
            data-description='Spring course checkout'
            data-image
                    ='https://www.baeldung.com/wp-content/themes/baeldung/favicon/android-chrome-192x192.png'
            data-locale='auto'
            data-zip-code='false'>
    </script>
</form>
</body>
</html>