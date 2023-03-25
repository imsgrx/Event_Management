package com.cdac.nashik.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cdac.nashik.entity.Booking;
import com.cdac.nashik.repository.BookingRepo;
import com.cdac.nashik.repository.BookingSupportRepo;

@Service
public  class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepo bookingDao;

	@Autowired
	private BookingSupportRepo bookingSupportRepo;

	@Override
	public Booking insertBookings(Booking booking) {
		return bookingDao.save(booking);
	}

	@Override
	public List<Booking> getAllBookings() {
		return bookingDao.findAll();
	}

	@Override
	public List<Booking> getBookingsByEmail(String email) {
		return bookingDao.findByEmail(email);
	}

	@Override
	public Booking updateBookings(Booking booking) {

		return bookingDao.save(booking);
	}

	@Override
	public void deleteBooking(int bookingId) {
		Booking book = bookingDao.getById(bookingId);

		bookingDao.delete(book);
	}

	@Override
	public List<Booking> pendingBookings(String email, boolean status) {
		return bookingDao.pendingBookings(email, false);
	}

	@Override
	public List<Booking> viewBookings(String email, boolean status) {
		return bookingDao.viewBookings(email, true);
	}

	@Override
	public List<Booking> viewAllPendingBookings(boolean status) {
		return bookingDao.viewAllPendingBookings(false);
	}

	@Override
	public List<Booking> viewAllBookings(boolean status) {
		return bookingDao.viewAllBookings(true);
	}
	@Override
	  public List<Booking> getBookingsById(int bookingId) { 
	  return bookingSupportRepo.findByBookingId(bookingId);
	  }

	@Override
	public List<Booking> findByCityAndDate(String city, String date) {
		
		return bookingDao.findByCityAndDate(city, date);

	} 
	


  }
 
