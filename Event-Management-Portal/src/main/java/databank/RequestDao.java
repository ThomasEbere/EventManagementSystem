package databank;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import app.Request;
import app.Student;

@Transactional
@Repository
public class RequestDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate=hibernateTemplate;
	}
	
	public Request getRequestById(int id) {
		return (Request) hibernateTemplate.get(Request.class, id);
	}
	
	public List<Request> getMyRequest(String email) {
		String queryString="FROM Request r where r.email=?0";
		return (List<Request>) hibernateTemplate.find(queryString,email);
	}
	
	public void updateEventStatus(Request request,int id) {
		
		hibernateTemplate.saveOrUpdate(request);
	}
	
	public void addRequest(Request request) {
		hibernateTemplate.save(request);
	}
	
	public List<Request> getallRequest()
	{
		return (List<Request>)hibernateTemplate.find("from Request");
	}

}
