package databank;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import app.Student;
import app.Users;


@Transactional
@Repository
public class UsersDao {
	

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public void addUser(Users user)
	{
		hibernateTemplate.save(user);
	}
	
	public Users getUserID(int pid) {
		return hibernateTemplate.get(Users.class, pid);
	}
	
	public List<Users> getUserByEmail(String email) {
		String queryString="FROM Users u where u.email=?0";
		return  (List<Users>) hibernateTemplate.find(queryString, email);
	}
	
	public void updateUser(Users user)
	{
		hibernateTemplate.update(user);
	}
	
	public void deleteUser(int pid) {
		hibernateTemplate.delete(getUserID(pid));
	}
	
	public List<Users> getAllUsers()
	{
		return (List<Users>) hibernateTemplate.find("from Users");
	}
}
