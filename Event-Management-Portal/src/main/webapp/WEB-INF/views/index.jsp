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
<header>
        <h1>Welcome To Prime University</h1>
    </header>
    <h2>Please submit your details below</h2>
    <div class="mydiv">
        <form action="save" method="post">
            <div class="innerdiv">
            <div class="newdiv firstdiv">
                <label for="firstname">first Name</label>
                <input type="text"  name="firstName" required>
            </div>
            <div class="newdiv">
                <label for="firstname">last Name</label>
                <input type="text"  name="lastName" required>
            </div>
            <div class="newdiv">
                <label for="email">Email</label>
                <input type="text"  name="email" required>
            </div>
            <div class="newdiv">
                <label for="password">password</label>
                <input type="password"  name="password" required>
            </div>
           
    		<a href="/Event-Management-Portal" class="signlogged">Login</a>

        	<div class="newdiv lastdiv">
            <input type="submit"  name="" value="submit">
        	</div>
    		</div>
        </form>
    </div>
</body>
</html>