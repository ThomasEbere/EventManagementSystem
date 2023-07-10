package databank;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import app.Payments;
import app.Users;

@Transactional
@Repository
public class PaymentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	public void addPaymentRecord(Payments payment)
	{
		hibernateTemplate.save(payment);
	}
	
	public Payments getPaymentById(int pid) {
		return hibernateTemplate.get(Payments.class, pid);
	}
	
//	public List<Users> getUserByEmail(String email) {
//		String queryString="FROM Users u where u.email=?0";
//		return  (List<Users>) hibernateTemplate.find(queryString, email);
//	}
	
//	public void updateUser(Users user)
//	{
//		hibernateTemplate.update(user);
//	}
	
	public void deletPaymentById(int pid) {
		hibernateTemplate.delete(getPaymentById(pid));
	}
	
	public List<Payments> getAllPaymenrt()
	{
		return (List<Payments>) hibernateTemplate.find("from Payments");
	}
}
