<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/mystyle.css" rel ="stylesheet">
</head>
<body>
<header>
        <h1>Welcome To Thomas Event Booking System</h1>
    </header>
<div class="mydiv topdiv thelogin">
    <h2>Please supply details to login</h2>
    <form action="userlogin" method="post">
        <div class="innerdiv myadmin login ">
    <p>${message }</p>
        <div class="newdiv">
            <label for="email">Email</label>
            <input type="text"  name="email">
        </div>
        <div class="newdiv">
            <label for="phonenumber">Password</label>
            <input type="password"  name="password">
      </div>
        <div class="newdiv lastdiv">
        <input type="submit"  name="" value="submit" class="loginsub">
    </div>
</div>
    </form>
</div>
</body>
</html>