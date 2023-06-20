package emailservice;
//import java.util.UUID;
//
//public class Emails {
//
//	public String getID() {
//		
//		return UUID.randomUUID().toString();
//	}
//	
//	public static void main (String [] args) {
//		
//		Emails mytest= new Emails();
//		
//		System.out.println(mytest.getID());
//	}
//}

import java.util.*;


import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import emailservice.RandomNumber;

public class Emails{
	
	
	
	public String getEmail(int id,String email, String userid) {
		
//		String to=email;
		
		//Sender's email ID
		String from= "thomasebere119@gmail.com";
		
		String username="thomasebere119@gmail.com";
		String password= "puzeghjhksczmubz";
		
		//Assuming you are sending email from localhost
		String host ="smtp.gmail.com";
		
		//Get system properties
		Properties properties = System.getProperties();
		
		//Setup mail server
		properties.setProperty("mail.host", host);
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		
		//Setting Authentication 
		

		
		//Get the default session object
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(username, password);

            }

        });
		
		try {
			//Create a default MimeMessage Object
			MimeMessage message = new MimeMessage(session);
			
			//Set From: header field of the header
			message.setFrom(new InternetAddress(from));
			
			//Set To: header field of the header
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			
			// Set Subject: Header field
			message.setSubject("This is the subject line");
			
			//Now set the actual message
			String URL= "Please click on this link to complete your registration <a href=\"http://localhost:8080/Event-Management-Portal/validate/"+id+"/"+email+"/"+userid+"\">Welcome</a>";
			

			message.setContent(URL, "text/html");
			
			// Send Message
			
			Transport.send(message);
			
		}
		catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return "Successful";
	}
	
	public String approvedRequest(String email) {
		String from= "thomasebere119@gmail.com";
		
		String username="thomasebere119@gmail.com";
		String password= "puzeghjhksczmubz";
		
		//Assuming you are sending email from localhost
		String host ="smtp.gmail.com";
		
		//Get system properties
		Properties properties = System.getProperties();
		
		//Setup mail server
		properties.setProperty("mail.host", host);
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		
		//Setting Authentication 
		

		
		//Get the default session object
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(username, password);

            }

        });
		
		try {
			//Create a default MimeMessage Object
			MimeMessage message = new MimeMessage(session);
			
			//Set From: header field of the header
			message.setFrom(new InternetAddress(from));
			
			//Set To: header field of the header
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			
			// Set Subject: Header field
			message.setSubject("Request Approved");
			
			//Now set the actual message
			String URL= " The request you put in has been submitted. Please watch out for the next email which would prompt you to make payment";
			

			message.setContent(URL, "text/html");
			
			// Send Message
			
			Transport.send(message);
			
		}
		catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return "Successful";
	}
	
//	public static void main (String [] args)
//	{
//		
//		Emails test= new Emails();
//		RandomNumber randoms = new RandomNumber();
//		System.out.println(test.getEmail("tebere.chukwuka@gmail.com", randoms.generateString()));
//		
//		
//	}
	
	
	
	
}
