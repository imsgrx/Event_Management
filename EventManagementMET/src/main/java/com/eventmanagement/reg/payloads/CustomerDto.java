package com.eventmanagement.reg.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Size;

public class CustomerDto { 
//This Class is use to transfer DATA!	
	
	
	private int id;
	
	@NotEmpty
	@Size(min = 2,message = "Name Should be Greater Than 2 Characters")
	private String name;
	
	@Email(message = "Email is not valid")
	private String email;
	
	@NotEmpty
	@Size(min = 4,max = 12)
	private String password;
	
	@NotEmpty
	@Size(min = 10,max = 10)
	private String contactno;
	
	public CustomerDto() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerDto(String name, String email, String password, String contactno) {
		super();
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
		return "CustomerDto [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", contactno=" + contactno + "]";
	}
	
	
	
	
}
