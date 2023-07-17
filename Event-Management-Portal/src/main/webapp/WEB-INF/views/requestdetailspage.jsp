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
 <div class="request-details-page">
        <div class="event-details myevent">
            <h3>Request Details</h3>
            <p>Event Name ${request.eventName }</p>
            <p>Event Description: ${request.eventDescription }</p>
            <p id="status">Status: ${request.status }</p>
            <p>Hall of choice: ${request.location }</p>
        </div>
        <div class="event-location myevent">
            <h3>Event Location</h3>
            <p>Province: ${request.province }</p>
            <p>City: ${request.city }</p>
            <p>Postal Code: ${request.postalCode }</p>
        </div>
        <div class="event-contact-details myevent">
            <h3>Contact Details</h3>
            <p>Email: ${request.email }</p>
            <p>Phone Number: ${request.phoneNumber }</p>
        </div>
        <div class="request-details myevent">
            <h3>Request Hours</h3>
            <p>Event Start Date:${request.eventStartDate }</p>
            <p>Event End Date: ${request.eventEndDate }</p>
        </div>
        <div class="decision-button myevent">
            <button id ="myapprove"><a id ="linkelem" href="/Event-Management-Portal/approved/${request.id }">approve</a></button>
            <button><a href="/Event-Management-Portal/rejected/${request.id }">Reject</a></button>
        </div>
    </div>
    <script>
    
    let statuselement=document.getElementById("status");
    let elem=document.getElementById("myapprove");
    let item=document.getElementById("linkelem");
    function change()
    {
    	
        if(statuselement.innerText.includes("Approved"))
        {
            elem.innerHTML="<a href='/Event-Management-Portal/payment/${request.id}'>Generate payment</a>";
            return false;
        }
    }
    
    change();
    
    function reSendPaymentLink()
    {
    	if ( statuselement.innerText.includes("Sent Payment Link")){
    		elem.innerHTML="<a href='/Event-Management-Portal/payment/${request.id}'>Resend Payment Link</a>"
    	}
    }
    
    reSendPaymentLink();
    
    </script>
</body>
</html>