package com.eventmanagement.reg.controllers;

import java.lang.invoke.CallSite;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagement.reg.entities.Booking;
import com.eventmanagement.reg.payloads.ApiResponse;
import com.eventmanagement.reg.payloads.BookingDto;
import com.eventmanagement.reg.services.BookingService;

@RestController
@RequestMapping("/api/")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	
	//create	
	@PostMapping("/customer/{customerId}/category/{categoryId}/booking")
	public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto, @PathVariable Integer customerId, @PathVariable Integer categoryId)
	{
		BookingDto createBooking = this.bookingService.createBooking(bookingDto,customerId,categoryId);
		return new ResponseEntity<BookingDto>(createBooking,HttpStatus.CREATED);
	}
	
	
	//Get By User
	@GetMapping("/customer/{customerId}/bookings")
	public ResponseEntity<List<BookingDto>> getBookingsByCustomer(@PathVariable Integer customerId ){
		List<BookingDto> bookings = this.bookingService.getBookingByCustomer(customerId);
		return new ResponseEntity<List<BookingDto>> (bookings,HttpStatus.OK);
	}
	
	
	//Get By Category
	
	@GetMapping("/category/{categoryId}/bookings")
	public ResponseEntity<List<BookingDto>> getBookingsByCategory(@PathVariable Integer categoryId ){
		List<BookingDto> bookings = this.bookingService.getBookingByCategory(categoryId);
		return new ResponseEntity<List<BookingDto>> (bookings,HttpStatus.OK);
	}
	
	//Get all post
	
	@GetMapping("/bookings")
	public ResponseEntity<List<BookingDto>> getAllBooking()
	{
		List<BookingDto> allBooking = this.bookingService.getAllBooking();
		return new ResponseEntity<List<BookingDto>>(allBooking,HttpStatus.OK);
	}
	
	
	//Get post details by id
	
	@GetMapping("/bookings/{bookingId}")
	public ResponseEntity<BookingDto> getBookingById(@PathVariable Integer bookingId)
	{
		BookingDto bookingDto = this.bookingService.getBookingById(bookingId);
		return new ResponseEntity<BookingDto>(bookingDto,HttpStatus.OK);
	}
	
	//Delete booking
	@DeleteMapping("/bookings/{bookingId}")
	public ApiResponse deleteBooking(@PathVariable Integer bookingId)
	{
		this.bookingService.deleteBooking(bookingId);
		return new ApiResponse("Booking is Successfully deleted",true);
	}
}
