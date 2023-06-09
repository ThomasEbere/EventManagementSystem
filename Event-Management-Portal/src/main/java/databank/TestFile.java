package databank;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.Student;

@Transactional
@Controller
public class TestFile {
	
	@Autowired
	StudentDao student;
	
	public void getData() {
		System.out.println (student.getstudentByID(1));
	}
	public static void main (String [] args) {
		TestFile test= new TestFile();
		test.getData();
		Student newStudent= new Student();
	}
	
	
	

}
