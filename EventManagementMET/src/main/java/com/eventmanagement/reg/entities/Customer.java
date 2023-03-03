package com.eventmanagement.reg.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")

public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	@Column(name = "user_name",nullable = false,length = 100)
	private String name;
	
	@Column(name = "email_id")
	private String email;
	
	private String password;
	
	@Column(name = "contact_no",length = 10)
	private String contactno;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Feedback> feedbacks = new ArrayList<>();
	
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}



	public Customer(int id, String name, String email, String password, String contactno, List<Booking> bookings,
			List<Feedback> feedbacks) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactno = contactno;
		this.bookings = bookings;
		this.feedbacks = feedbacks;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getContactno() {
		return contactno;
	}



	public void setContactno(String contactno) {
		this.contactno = contactno;
	}



	public List<Booking> getBookings() {
		return bookings;
	}



	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}



	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}



	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	


	
	
}
