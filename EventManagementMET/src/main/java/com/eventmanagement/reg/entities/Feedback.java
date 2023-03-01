package com.eventmanagement.reg.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackId;
	
	@Column(name = "email", length = 20,nullable = false)
	private String email;
	
	@Column(name = "subject", length = 25,nullable = false)
	private String subject;
	
	@Column(name = "message", length = 150)
	private String message;
	
	@ManyToOne
	private Customer customer;
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	public Feedback(int feedbackId, String email, String subject, String message, Customer customer) {
		super();
		this.feedbackId = feedbackId;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.customer = customer;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", email=" + email + ", subject=" + subject + ", message="
				+ message + ", customer=" + customer + "]";
	}
	
	
}
