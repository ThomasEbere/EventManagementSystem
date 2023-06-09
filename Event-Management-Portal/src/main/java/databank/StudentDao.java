package databank;

import java.sql.SQLException;
import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import app.Student;

@Transactional
@Repository
public class StudentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public boolean addStudent(Student student) 
	{
		
		try {
			hibernateTemplate.save(student);
			return true;
		}
		catch(DataIntegrityViolationException e) {
			System.out.println("Email already exist");
			hibernateTemplate.clear();
			hibernateTemplate.flush();
			return false;
		}

	}
	
	public Student getstudentByID(int pid) {
		return hibernateTemplate.get(Student.class, pid);
	}
	
	public List<Student> getStudentByEmail(String email) {
		String queryString="FROM Student s where s.email=?0";
		return (List<Student>) hibernateTemplate.find(queryString,email);
	}
	
	public void updateStudent(Student student)
	{
		hibernateTemplate.update(student);
	}
	
	public void updateStudentStatus(Student student,String email) {
		
		hibernateTemplate.saveOrUpdate(student);
	}
	
	public void deleteStudent(int pid) {
		hibernateTemplate.delete(getstudentByID(pid));
	}
	
	public List<Student> getAllStudent()
	{
		return (List<Student>) hibernateTemplate.find("from Student");
	}
}
