package routers;

import java.util.List;

import java.util.Locale;
import java.util.UUID;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stripe.exception.AuthenticationException;
import com.stripe.exception.StripeException;

import app.ChargeRequest;
import app.Payments;
import app.Request;
import app.StripeService;
import app.Student;
import app.Users;
import databank.PaymentDao;
import databank.RequestDao;
import databank.StudentDao;
import databank.UsersDao;
import emailservice.Emails;
import com.stripe.model.Charge;
import java.util.Date;



//@Configuration 
@Transactional
@Controller
@PropertySource(value= {"classpath:application.properties"})
public class Routers {
	
	Emails emails = new Emails();
	
	Request request;
	
	Payments payments = new Payments();
	
	@Autowired
	StudentDao students;
	
	@Autowired
	UsersDao users;
	
	@Autowired
	RequestDao requests;
	
	@Autowired
	PaymentDao payment;
	
	@Autowired
    private StripeService paymentsService;
	
	@RequestMapping("/")
	public String login() {
		return "studentlogin";
	}
	
	@RequestMapping("/usersignup")
		public String userSignup() {
			return "index";
		}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String getData(@ModelAttribute("student") Student student, BindingResult bindingResult)
	{
		String useridentifier=UUID.randomUUID().toString();
		student.setUserid(useridentifier);
		if(students.addStudent(student) ==true) {
			emails.getEmail(student.getId(),student.getEmail(), useridentifier);
		}
		else {
			return "index";
		}
		
		return "saved";
	}
	
	@RequestMapping("/user")
	public String userlogin(HttpSession session) {
		if(session.getAttribute("email")!=null) {
			String email=(String) session.getAttribute("email");
		return "redirect:/userhomepage";
		}
		return "users";
	}
	
	@RequestMapping(value="/userlogin", method=RequestMethod.POST)
	public String userverification(@ModelAttribute("user") Users user, BindingResult bindingResult, Model model, HttpServletRequest request) {
		
		List<Users> myUser= users.getUserByEmail(user.getEmail());
		
		for(Users newUser:myUser) {
			if(user.getEmail().equals(newUser.getEmail()) && user.getPassword().equals(newUser.getPassword())) {
				
				HttpSession session= request.getSession();
				session.setAttribute("email", user.getEmail());
				return "redirect:/userhomepage";	
			}
		}
		String message="Please re-enter email and password";
		model.addAttribute("message", message);
		return "users";
	}
	
	@RequestMapping(value="/userhomepage")
	public String userHomePage(Model model) {
		
		List<Request> request=requests.getAllNonPaidRequest();
		model.addAttribute("request", request);
		return "success";
	}
	
	@RequestMapping(value="/validate/{id}/{email}/{userid}")
	public String validateuser(@ModelAttribute("student") Student student, BindingResult bindingResult, @PathVariable int id, @PathVariable String email, @PathVariable String userid)
	{
		List<Student> newStudent=students.getStudentByEmail(email);
		for(Student mystudent:newStudent) {
			mystudent.setStatus(true);
			students.updateStudentStatus(mystudent,email );
		}
		return "studentlogin";
	}
	
	@RequestMapping("/signup")
	public String adminRegistration() {
		return "signup";
	}
	
	@RequestMapping(value="/adminergistration",method=RequestMethod.POST)
		public String admin(Users user, BindingResult bindingResult, Model model, HttpSession session) {
		if(session.getAttribute("email")!=null) {
			users.addUser(user);
			return "redirect:/userhomepage";
		}
		return "users";
	}
	
	@RequestMapping(value="/getallrequest")
	public String request(Model model, HttpSession session) {
		
		if(session.getAttribute("email")!=null) {
			String email=(String) session.getAttribute("email");
			List<Request> request= requests.getallRequest();
			
			model.addAttribute("myrequest", request);
			return "success";
		}
		return "redirect:/user";
	}
	
	@RequestMapping(value="/login")
	public String testUpdate(@ModelAttribute("student") Student student, BindingResult bindingResult, HttpServletRequest request) {
		String userEmail=student.getEmail();
		if(userEmail!=null)
		{
			List<Student> newStudent=students.getStudentByEmail(userEmail);
			for(Student myStudent:newStudent) {
				if(userEmail.equals(myStudent.getEmail()) && student.getpassword().equals(myStudent.getpassword()) && myStudent.isStatus()==true) {
					
					HttpSession session= request.getSession();
					session.setAttribute("email",student.getEmail());
					
					return "redirect:homepage";
				}
				else if(userEmail.equals(myStudent.getEmail()) && student.getpassword().equals(myStudent.getpassword()) && myStudent.isStatus()==false)
				{
					System.out.println("You need to confirm your account");
				}
			}

		}
		return "studentlogin";
	}
	
	@RequestMapping("/homepage")
	public String homepage(HttpSession session, Model model) {
		
		if(session.getAttribute("email")!=null) {
			
			String email=(String) session.getAttribute("email");
			List<Student> newStudent=students.getStudentByEmail(email);
			
			for(Student student:newStudent) {
				
				model.addAttribute("firstname", student.getFirstName());
				return "landingpage";
			}
			
		}

		return "redirect:/login";
	}
	
	
	@RequestMapping("/submitrequest")
	public String submitRequest(HttpSession session) {
			if(session.getAttribute("email")!=null) {
			return "submitrequest";
			}
			
			return "redirect:/login";
	}
	
	@RequestMapping("/request")
	public String submitRequest(@ModelAttribute("request") Request request, BindingResult bindingResult, HttpSession session)
	{
		if(session.getAttribute("email")!=null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.US);
			String startDate=request.getEventStartDate();
			String endDate=request.getEventEndDate();
			LocalDateTime localDate = LocalDateTime.parse(startDate, formatter);
			LocalDateTime newlocalDate = LocalDateTime.parse(endDate, formatter);
			String newStartDate = (DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(localDate));
			
			String newEndDate = (DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(newlocalDate));
			request.setEventStartDate(newStartDate);
			request.setEventEndDate(newEndDate);
			request.setStatus("New");
			requests.addRequest(request);
			return "redirect:/homepage";
			}
		return "redirect:/login";
		
	}
	
	@RequestMapping(value="/request/{id}")
	public String requestDetail(@PathVariable("id") int id, Model model, HttpSession session) {
		
		if(session.getAttribute("email")!=null) {

		Request request = requests.getRequestById(id);
		
		model.addAttribute(request);
		
		return "requestdetailspage";
		}
		return "redirect:/user";
	}
	
	@RequestMapping(value="/approved/{id}")
	public String approvedRequest(Model model, @PathVariable("id") int id) {
		
		Request request = requests.getRequestById(id);
		emails.approvedRequest(request.getEmail());
		request.setStatus("Approved");
		requests.updateEventStatus(request, id);
		
		model.addAttribute("email", request.getEmail());
		
		model.addAttribute("requestid", id);
		
		return "payments";
	}
	
	@RequestMapping(value="/viewSubmittedRequests")
	public String viewSubmittedRequest(@ModelAttribute("student") Student student, HttpSession session, Model model) {
		
			if(session.getAttribute("email")!=null) {
			String email=(String) session.getAttribute("email");
			List<Request> request= requests.getMyRequest(email);
			for(Request myrequest:request) {
				System.out.println(myrequest.getEventName());
			}
			model.addAttribute("requests", request);
			return "requestinfo";
		}
		return "redirect:/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session !=null) {
			session.invalidate();
		}
		return "redirect:/login";
	}
	
	@RequestMapping("admin/logout")
	public String adminlogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session !=null) {
			session.invalidate();
		}
		return "redirect:/user";
	}
	
	@RequestMapping("/usermanager")
	public String usermanager(HttpSession session) {
		if(session.getAttribute("email")!=null) {
		return "adminusers";
		}
		return "redirect:/user";
	}
	
	@RequestMapping("/adminusers")
	public String alladminuser(Model model, HttpSession session) {
		List<Users> myUser= users.getAllUsers();
		
		if(session.getAttribute("email")!=null) {

		model.addAttribute("user", myUser);
		
		return "alladminusers";
		}
		return "users";
	}
	
	@RequestMapping("/allregularusers")
	public String allRegularUsers(Model model, HttpSession session) {
		if(session.getAttribute("email")!=null) {
			List<Student> student = students.getAllStudent();	
			model.addAttribute("studentlist", student);
			return "allstudentlist";
		}
		return "users";
	}
	
	@RequestMapping("/payment/{id}")
	public String makePayment(Model model,@PathVariable("id") int id)
	{
		Request request = requests.getRequestById(id);
		request.setStatus("Approved");
		requests.updateEventStatus(request, id);
		
		model.addAttribute("myemail", request.getEmail());
		
		model.addAttribute("requestid", id);
		return "payments";
	}
	
	
	@Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;
	
	@RequestMapping("/checkout/{amount}/{id}")
	public String checkout(Model model, @PathVariable("amount") int amount, @PathVariable("id") int id) {
		
		Request request= requests.getRequestById(id);
		System.out.println(request.getStatus());
		if (request.getStatus().contentEquals("Paid")){
			String message ="Paid";
			System.out.println(message);
			model.addAttribute("message", message);
			return "data";
		}
		else {
			model.addAttribute("amount", amount);
	        System.out.println(amount);
	        model.addAttribute("stripePublicKey",stripePublicKey);
	        System.out.println(stripePublicKey);
	        model.addAttribute("currency",ChargeRequest.Currency.USD);
			return "data";
		}
	}
	
	@RequestMapping("/generatepayment")
	public String generatePayment(Model model, @RequestParam("amount") int amount, @RequestParam("id") int id, @RequestParam("email") String email)
	{
		System.out.println(amount);
		System.out.println(id);
		System.out.println(email);
		Request request = requests.getRequestById(id);
		request.setStatus("Sent Payment Link");
		requests.updateEventStatus(request, id);
		emails.makePayment(id, amount, email);
		return "thisdata";
	}
	
	@PostMapping("/charge/{id}")
    public String charge(ChargeRequest chargeRequest,Model model, @PathVariable("id") int id, @RequestParam("amount") int amount) throws StripeException, AuthenticationException, javax.naming.AuthenticationException {
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(ChargeRequest.Currency.USD);
        System.out.println("This is the token" + chargeRequest.getStripeToken());
        
       
        
		Charge charge = paymentsService.charge(chargeRequest);
		if(charge.getStatus().contentEquals("succeeded")) {
			Request request = requests.getRequestById(id);
			request.setStatus("Paid");
			requests.updateEventStatus(request, id); 
			Date date= new Date();
		    String paymentDate=date.toLocaleString(); 
		    payments.setRequestId(id);
		    payments.setPaymentId(charge.getId());	 
		    payments.setAmount(amount);
		    payments.setPaymentDate(paymentDate);
		    payment.addPaymentRecord(payments);
		    return "paid";
		    
		}  
//        model.addAttribute("id", charge.getId());
//        model.addAttribute("status", charge.getStatus());
//        model.addAttribute("chargeId", charge.getId());
//        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }
	
	@RequestMapping("/rejected/{id}")
	public String rejectRequest(@PathVariable("id") int id) {
		Request request = requests.getRequestById(id);
		request.setStatus("Rejected");
		requests.updateEventStatus(request, id); 
		return "redirect:/userhomepage";
	}
	


}
