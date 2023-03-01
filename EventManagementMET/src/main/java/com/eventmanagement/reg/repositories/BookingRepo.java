package com.eventmanagement.reg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanagement.reg.entities.Booking;
import com.eventmanagement.reg.entities.Category;
import com.eventmanagement.reg.entities.Customer;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

	List<Booking> findByCustomer(Customer customer);
	List<Booking> findByCategory(Category category);
}
