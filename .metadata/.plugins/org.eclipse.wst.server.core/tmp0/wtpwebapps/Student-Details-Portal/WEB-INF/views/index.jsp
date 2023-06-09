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
    <h1>Welcome to my student registration Portal</h1>
    <h2>Please submit your details below</h2>
    <div class="mydiv">
        <form action="save" method="post">
            <div class="innerdiv">
            <div class="newdiv firstdiv">
                <label for="firstname">first Name</label>
                <input type="text"  name="firstName">
            </div>
            <div class="newdiv">
                <label for="firstname">last Name</label>
                <input type="text"  name="lastName">
            </div>
            <div class="newdiv">
                <label for="email">Email</label>
                <input type="text"  name="email">
            </div>
            <div class="newdiv">
                <label for="phonenumber">phoneumber</label>
                <input type="text"  name="phoneNumber">
            </div>
            <div class="newdiv">
            <label for="address">Address</label>
            <input type="text"  name="Address">
        </div>
        <div class="newdiv">
            <label for="address">Upload file</label>
            <input type="file"  name="data">
        </div>
        <div class="newdiv lastdiv">
            <input type="submit"  name="" value="submit">
        </div>
    </div>
        </form>
    </div>
</body>
</html>