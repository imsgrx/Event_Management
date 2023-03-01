package com.eventmanagement.reg.payloads;

import java.util.Date;

import com.eventmanagement.reg.entities.Category;
import com.eventmanagement.reg.entities.Customer;

public class BookingDto {
	
	private int bookingId;
	private boolean bookingStatus;
	private Date bookingDate;
	private CategoryDto category;
	private CustomerDto customer;
	private String fullAddress;
	
	public BookingDto() {
		// TODO Auto-generated constructor stub
	}

	public BookingDto(int bookingId, boolean bookingStatus, Date bookingDate, CategoryDto category,
			CustomerDto customer, String fullAddress) {
		super();
		this.bookingId = bookingId;
		this.bookingStatus = bookingStatus;
		this.bookingDate = bookingDate;
		this.category = category;
		this.customer = customer;
		this.fullAddress = fullAddress;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public boolean isBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public CustomerDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	@Override
	public String toString() {
		return "BookingDto [bookingId=" + bookingId + ", bookingStatus=" + bookingStatus + ", bookingDate="
				+ bookingDate + ", category=" + category + ", customer=" + customer + ", fullAddress=" + fullAddress
				+ "]";
	}

	
	
	
	
	
	
	
}
