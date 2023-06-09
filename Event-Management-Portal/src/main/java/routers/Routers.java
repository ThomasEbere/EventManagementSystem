package routers;

import java.util.List;
import java.util.UUID;

import java.sql.*;



import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.Student;
import app.Users;
import databank.StudentDao;
import databank.UsersDao;
import emailservice.Emails;


@Transactional
@Controller
public class Routers {
	
	Emails email = new Emails();
	
	@Autowired
	StudentDao students;
	
	@Autowired
	UsersDao users;
	
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
	public String testpage() {
		return "users";
	}
	
	@RequestMapping(value="/saveuser",method=RequestMethod.POST)
	public String saveadmins(@ModelAttribute("user") Users user, BindingResult bindingResult)
	{
		System.out.println("Data got here");
		System.out.println(user.getFirstName());
		users.addUser(user);
		return "usersaved";
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
	public String signUp() {
		Student student=students.getstudentByID(1);
		System.out.println(student.getFirstName());
		return "signup";
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
	
	
	@RequestMapping("/homepage/submitrequest")
	public String submitRequest() {
		return "submitrequest";
	}
	
//	@RequestMapping(value="/user",method=RequestMethod.POST)
//	public String getuserData(@ModelAttribute("user") Users user, BindingResult bindingResult)
//	{
//		users.addUser(user);
//		return "users";
//	}

}
