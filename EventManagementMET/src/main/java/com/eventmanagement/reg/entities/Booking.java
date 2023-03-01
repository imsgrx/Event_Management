package com.eventmanagement.reg.entities;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "booking_id")
	private int bookingId;
	
	@Column(name = "booking_date")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date bookingDate;
	
	@Column(name = "fulladdress")
	private String fullAddress;
	
	@Column(name = "booking_status")
	private boolean bookingStatus;
	
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	private Customer customer;
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(int bookingId, Date bookingDate, String fullAddress, boolean bookingStatus, Category category,
			Customer customer) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.fullAddress = fullAddress;
		this.bookingStatus = bookingStatus;
		this.category = category;
		this.customer = customer;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public boolean isBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", fullAddress=" + fullAddress
				+ ", bookingStatus=" + bookingStatus + ", category=" + category + ", customer=" + customer + "]";
	}

	
	
	
	
	
}
