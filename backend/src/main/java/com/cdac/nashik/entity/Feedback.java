package com.cdac.nashik.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feedback {
	@Id
	private String name;
	private String email;
	private String mobileno;
	private String service;
	private String message;
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	public Feedback(String name, String email, String mobileno, String service, String message) {
		super();
		this.name = name;
		this.email = email;
		this.mobileno = mobileno;
		this.service = service;
		this.message = message;
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

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Feedback [name=" + name + ", email=" + email + ", mobileno=" + mobileno + ", service=" + service
				+ ", message=" + message + "]";
	}
	
	
}
