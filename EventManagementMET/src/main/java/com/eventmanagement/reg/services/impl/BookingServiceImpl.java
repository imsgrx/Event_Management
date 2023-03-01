package com.eventmanagement.reg.services.impl;

import java.util.Date;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagement.reg.entities.Booking;
import com.eventmanagement.reg.entities.Category;
import com.eventmanagement.reg.entities.Customer;
import com.eventmanagement.reg.exceptions.ResourceNotFoundException;
import com.eventmanagement.reg.payloads.BookingDto;
import com.eventmanagement.reg.payloads.CategoryDto;
import com.eventmanagement.reg.repositories.BookingRepo;
import com.eventmanagement.reg.repositories.CategoryRepo;
import com.eventmanagement.reg.repositories.CustomerRepo;
import com.eventmanagement.reg.services.BookingService;


@Service
public class BookingServiceImpl implements BookingService
{
	@Autowired
	private BookingRepo bookingRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	
	
	@Override
	public BookingDto createBooking(BookingDto bookingDto, Integer customerId, Integer categoryId) {
		
		
		Customer customer = this.customerRepo.findById(customerId)
				.orElseThrow(()->new ResourceNotFoundException("Customer","Customer id",customerId));

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","Category id",categoryId));
		
		Booking booking = this.modelMapper.map(bookingDto, Booking.class);
		booking.setBookingDate(new Date());
		booking.setCustomer(customer);
		booking.setCategory(category);
		
		Booking newBooking = this.bookingRepo.save(booking);
		return this.modelMapper.map(newBooking, BookingDto.class);
	}

	@Override
	public Booking updateBooking(BookingDto bookingDto, Integer bookingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBooking(Integer bookingId) {
		Booking booking = this.bookingRepo.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Booking","booking id",bookingId));
		this.bookingRepo.delete(booking);
	}

	@Override
	public List<BookingDto> getAllBooking() {
		List<Booking> allBookings = this.bookingRepo.findAll();
		
		List<BookingDto> bookingDtos = allBookings.stream().map((booking)->this.modelMapper.map(booking, BookingDto.class))
				.collect(Collectors.toList());
		return bookingDtos;
	}

	@Override
	public BookingDto getBookingById(Integer bookingId) {
		Booking booking = this.bookingRepo.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Booking","booking id",bookingId));
		return this.modelMapper.map(booking, BookingDto.class);
	}

	@Override
	public List<BookingDto> getBookingByCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));
		List<Booking> bookings = this.bookingRepo.findByCategory(cat);
		
		 List<BookingDto> bookingDtos = bookings.stream().map((booking)-> this.modelMapper.map(booking, BookingDto.class)).collect(Collectors.toList());
		return bookingDtos;
	}

	@Override
	public List<BookingDto> getBookingByCustomer(Integer customerId) {
		
		Customer customer = this.customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","customerId",customerId));
		List<Booking> bookings = this.bookingRepo.findByCustomer(customer);
		
		List<BookingDto> bookingDtos = bookings.stream().map((booking)->this.modelMapper.map(booking, BookingDto.class)).collect(Collectors.toList());
		return bookingDtos;
	}

	@Override
	public List<Booking> searchBookings(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking createBooking() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Category dtoToCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);

		return category;
	}
	
	public CategoryDto categoryToDto(Category category) {
		CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}
	

}
