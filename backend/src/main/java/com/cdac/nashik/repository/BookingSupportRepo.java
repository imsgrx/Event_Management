package com.cdac.nashik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.nashik.entity.Booking;

public interface BookingSupportRepo extends JpaRepository<Booking, Integer> {
	
	public List<Booking> findByBookingId(int bookingId);
	

}
