package routers;

import java.util.List;
import java.util.UUID;

import java.sql.*;



import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.Request;
import app.Student;
import app.Users;
import databank.RequestDao;
import databank.StudentDao;
import databank.UsersDao;
import emailservice.Emails;


@Transactional
@Controller
public class Routers {
	
	Emails email = new Emails();
	
	Request request;
	
	@Autowired
	StudentDao students;
	
	@Autowired
	UsersDao users;
	
	@Autowired
	RequestDao requests;
	
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
			email.getEmail(student.getId(),student.getEmail(), useridentifier);
		}
		else {
			return "index";
		}
		
		return "saved";
	}
	
	@RequestMapping("/user")
	public String userlogin() {
		return "users";
	}
	
	@RequestMapping(value="/userlogin", method=RequestMethod.POST)
	public String userverification(@ModelAttribute("user") Users user, BindingResult bindingResult, Model model) {
		
		List<Users> myUser= users.getUserByEmail(user.getEmail());
		
		for(Users newUser:myUser) {
			if(user.getEmail().equals(newUser.getEmail()) && user.getPassword().equals(newUser.getPassword())) {
				
				return "redirect:/userhomepage";
					
			}
		}
		String message="Please re-enter email and password";
		model.addAttribute("message", message);
		return "users";
	}
	
	@RequestMapping(value="/userhomepage")
	public String userHomePage(Model model) {
		
		List<Request> request=requests.getallRequest();
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
		public String admin(Users user, BindingResult bindingResult, Model model) {
		
		users.addUser(user);
		
		
		
		return "users";
	}
	
	@RequestMapping(value="/getallrequest")
	public String request(Model model) {
		List<Request> request= requests.getallRequest();
		
//		for(Request myrequest:request) {
//			
//			System.out.println(myrequest.getEventName());
//		}
//		Request request = (Request) requests.getallRequest();
//		System.out.print(request.getEventName());
		model.addAttribute("myrequest", request);
		return "success";
	}
	
	@RequestMapping(value="/login")
	public String testUpdate(@ModelAttribute("student") Student student, BindingResult bindingResult) {
		
		String userEmail=student.getEmail();
		if(userEmail!=null)
		{
			List<Student> newStudent=students.getStudentByEmail(userEmail);
			for(Student myStudent:newStudent) {
				if(userEmail.equals(myStudent.getEmail()) && student.getpassword().equals(myStudent.getpassword()) && myStudent.isStatus()==true) {
					
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
	public String homepage() {
		
		return "landingpage";
	}
	
	
	@RequestMapping("/submitrequest")
	public String submitRequest() {
		return "submitrequest";
	}
	
	@RequestMapping("/request")
	public String submitRequest(@ModelAttribute("request") Request request, BindingResult bindingResult)
	{
		request.setStatus("New");
		requests.addRequest(request);
		return "landingpage";
	}
	
	@RequestMapping(value="/request/{id}")
	public String requestDetail(@PathVariable("id") int id, Model model) {
		Request request = requests.getRequestById(id);
		
		model.addAttribute(request);
		
		return "requestdetailspage";
	}
	
	@RequestMapping(value="/approved/{id}")
	public String approvedRequest(@PathVariable("id") int id) {
		
		Request request = requests.getRequestById(id);
		email.approvedRequest(request.getEmail());
		request.setStatus("Approved");
		requests.updateEventStatus(request, id);
		
		return "payment";
		
	}
	
	
//	@RequestMapping(value="/user",method=RequestMethod.POST)
//	public String getuserData(@ModelAttribute("user") Users user, BindingResult bindingResult)
//	{
//		users.addUser(user);
//		return "users";
//	}

}
