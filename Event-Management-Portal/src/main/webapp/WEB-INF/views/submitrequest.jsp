<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/mynewstyle.css" rel="stylesheet">
</head>
<body class="submit-request">
    <mytags:userstag/>
<h2 class="submit-event-tag">
        kindly submit the details of your event
    </h2>
    <form action="request" method="post">
    <div class="submit-event">
        <div class="event eventName">
            <label for="EventName">Enter Name of Event</label>
            <input type="text" name="eventName">
        </div>
        <div class="event description">
            <div class="province">
            <label for="Event">Enter Province</label>
            <select name="province" id="">
                <option value="Ontario">Ontario</option>
                <option value="Saskatchewan">Saskatchewan</option>
                <option value="New Brunswick">New Brunswick</option>
                <option value="Northwest Territories">Northwest Territorie</option>
                <option value="Atlantic Provices">Atlantic Provices</option>
                <option value="British Columbia">British Columbia</option>
                <option value="Manitoba">Manitoba</option>
                <option value="Newfoundland and Labradrador">Newfoundland and Labradrador</option>
                <option value="Yukon">Yukon</option>
                <option value="Quebec">Quebec</option>
                <option value="Alberta">Alberta</option>
                <option value="Nova Scotia">Nova Scotia</option>
                <option value="Prince Edward Island">Prince Edward Island</option>
                <option value="Nunavut">Nunavut</option>
            </select>
        </div>
        <div class="address-city">
            <label for="street">City</label>
            <input type="text" name="city">
        </div>
            <div class="postalcode">
                <label for="postalcode">Postal code</label>
                <input type="text" name="postalCode" class="postal">
            </div>
        </div>
        <div class="event eventDescription">
            <label for="EventName">Event Description</label>
            <input type="text" name="eventDescription">
            <div class=" eventlocation">
                <label for="EventName">Event Location</label>
                <select name="location" id="">
                    <option value="Bakersfield">Bakersfield</option>
                    <option value="Bridgeport">Bridgeport</option>
                    <option value="Weber">Weber</option>
                    <option value="Victoria">Victoria</option>
                </select>
            </div>
        </div>
        
        <div class="event ">
            <div class="phonenumber">
                <label for="EventName">Phone Number</label>
            <input type="text" name="phoneNumber">
            </div>
            <div class="email">
                <label for="EventName">Email</label>
            <input type="email" name="email">
            </div>
        </div>
        <div class="event">
            <div class="start-date">
                <label for="EventName">Start Date and Time</label>
            <input type="datetime-local" name="eventStartDate">
            </div>
            <div class="end-date">
                <label for="EventName">End Date and Time</label>
                <input type="datetime-local" name="eventEndDate"> 
            </div>
        </div>
            <input type="submit" value="submit" class="submit">
        </div> 
</form>
</body>
</html>