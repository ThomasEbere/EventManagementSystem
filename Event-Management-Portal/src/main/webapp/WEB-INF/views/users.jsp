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
        <h1>Welcome Prime University</h1>
    </header>
<div class="mydiv topdiv thelogin">
    <h2>Please supply details to login</h2>
    <form action="saveuser" method="post">
        <div class="innerdiv myadmin login ">
    
        <div class="newdiv">
            <label for="email">Email</label>
            <input type="text"  name="email">
        </div>
        <div class="newdiv">
            <label for="phonenumber">Password</label>
            <input type="password"  name="phonenumber">
      </div>
        <div class="newdiv lastdiv">
        <input type="submit"  name="" value="submit" class="loginsub">
    </div>
    <a href="signup" class="loginoptions">sign up</a>
</div>
    </form>
</div>
</body>
</html>