package com.eventmanagement.reg.payloads;

public class CustomerDto { 
//This Class is use to transfer DATA!	
	private int id; 
	private String name;
	private String email;
	private String password;
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
