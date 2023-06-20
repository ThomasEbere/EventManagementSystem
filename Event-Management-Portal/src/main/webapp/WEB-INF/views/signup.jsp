<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href ="resources/css/mystyle.css" rel="stylesheet">
</head>
<body>
<header>
        <h1>Welcome To Prime University</h1>
    </header>
<h1>Prime University Admin Portal</h1>
<div class="mydiv topdiv">
    <form action="adminergistration" method="POST">
        <div class="innerdiv myadmin">
        <div class="newdiv firstdiv">
            <label for="firstname">firstname</label>
            <input type="text"  name="firstName">
        </div>
        <div class="newdiv">
            <label for="firstname">lastname</label>
            <input type="text"  name="lastName">
        </div>
        <div class="newdiv">
            <label for="email">Email</label>
            <input type="text"  name="email">
        </div>
        <div class="newdiv">
            <label for="phonenumber">Password</label>
            <input type="password"  name="password">
      </div>
        <div class="newdiv lastdiv">
        <input type="submit"  name="" value="submit">
    </div>
    <a href="user" class="sign">sign In</a>
</div>
    </form>
</div>
</body>
</html>