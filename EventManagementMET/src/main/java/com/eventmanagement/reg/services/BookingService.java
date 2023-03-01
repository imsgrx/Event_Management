package com.eventmanagement.reg.services;

import java.util.List;

import com.eventmanagement.reg.entities.Booking;
import com.eventmanagement.reg.payloads.BookingDto;

public interface BookingService {
	//create
	
	BookingDto createBooking(BookingDto bookingDto,Integer customerId,Integer categoryId);
	
	//update
	
	Booking updateBooking(BookingDto bookingDto,Integer bookingId);
	
	//delete
	
	void deleteBooking(Integer bookingId);
	
	//get all bookings
	
	List<BookingDto> getAllBooking();
	
	//get single booking
	
	BookingDto getBookingById(Integer bookingId);
	
	//get all booking by category
	
	List<BookingDto> getBookingByCategory(Integer categoryId);
	
	//get all booking by Customer
	
	List<BookingDto> getBookingByCustomer(Integer customerId);
	
	//search bookings
	List<Booking> searchBookings(String keyword);

	Booking createBooking();
}
