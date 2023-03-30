package databank;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	public void addStudent(Student student)
	{
		hibernateTemplate.save(student);
	}
	
	public Student getstudentByID(int pid) {
		return hibernateTemplate.get(Student.class, pid);
	}
	
	public void updateStudent(Student student)
	{
		hibernateTemplate.update(student);
	}
	
	public void deleteStudent(int pid) {
		hibernateTemplate.delete(getstudentByID(pid));
	}
	
	public List<Student> getAllStudent()
	{
		return (List<Student>) hibernateTemplate.find("from Student");
	}
}
