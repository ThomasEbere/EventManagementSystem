package app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="requesttable")
public class Request {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="EventName")
	private String eventName;
	
	@Column(name="province")
	private String province;
	
	@Column(name="city")
	private String city;
	
	@Column(name="postalcode")
	private String postalCode;
	
	@Column(name="eventDescrip")
	private String eventDescription;
	
	@Column(name="location")
	private String location;
	
	@Column(name="phonenumber")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="eventstartdate")
	private String eventStartDate;
	
	@Column(name="eventenddate")
	private String eventEndDate;
	
	@Column(name="status")
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(String eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public String getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(String eventEndDate) {
		this.eventEndDate = eventEndDate;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Request(int id, String eventName, String province, String city, String postalCode, String eventDescription,
			String location, String phoneNumber, String email, String eventStartDate, String eventEndDate) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.province = province;
		this.city = city;
		this.postalCode = postalCode;
		this.eventDescription = eventDescription;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
	}

	public Request() {
		
	}
	
}
