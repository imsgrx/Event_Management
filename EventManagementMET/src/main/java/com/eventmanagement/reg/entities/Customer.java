package com.eventmanagement.reg.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")

public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name, String email, String password, String contactno) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactno = contactno;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", contactno="
				+ contactno + "]";
	}
	
	
}
