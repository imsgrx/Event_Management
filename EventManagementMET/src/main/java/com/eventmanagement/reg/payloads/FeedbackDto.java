package com.eventmanagement.reg.payloads;

public class FeedbackDto {
	private int feedbackId;
	private String email;
	private String subject;
	private String message;
	private CustomerDto customer;
	
	public FeedbackDto() {
		// TODO Auto-generated constructor stub
	}

	public FeedbackDto(int feedbackId, String email, String subject, String message, CustomerDto customer) {
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

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "FeedbackDto [feedbackId=" + feedbackId + ", email=" + email + ", subject=" + subject + ", message="
				+ message + ", customer=" + customer + "]";
	}
	
	
}
