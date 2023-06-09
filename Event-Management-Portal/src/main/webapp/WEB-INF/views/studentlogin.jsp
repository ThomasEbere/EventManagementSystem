<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<link href="${pageContext.request.contextPath}/resources/css/mynewstyle.css" rel="stylesheet">
</head>
<body>
    <header>
        <h1>Welcome To Thomas Event Booking Portal</h1>
    </header>
<div class="mydiv topdiv thelogin">
    <h2>Please supply details to login</h2>
    <form action="login">
        <div class="innerdiv myadmin login ">
    
        <div class="newdiv">
            <label for="email">Email</label>
            <input type="text"  name="email" required>
        </div>
        <div class="newdiv">
            <label for="password">Password</label>
            <input type="password"  name="password" required>
      </div>
        <div class="newdiv lastdiv">
        <input type="submit"  name="" value="submit" class="loginsub">
    </div>
    <a href="usersignup" class="sign logged">sign up</a>
</div>
    </form>
</div>
</body>
</html>