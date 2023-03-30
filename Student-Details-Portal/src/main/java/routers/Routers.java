package routers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.Student;
import app.Users;
import databank.StudentDao;
import databank.UsersDao;

@Transactional
@Controller
public class Routers {
	
	@Autowired
	StudentDao students;
	UsersDao users;
	
	@RequestMapping("/")
	public String homepage() {
		return "index";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String getData(@ModelAttribute("student") Student student, BindingResult bindingResult)
	{
		students.addStudent(student);
		return "saved";
	}
	
	@RequestMapping("/user")
	public String testpage() {
		return "users";
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String getuserData(@ModelAttribute("user") Users user, BindingResult bindingResult)
	{
		users.addUser(user);
		return "users";
	}

}