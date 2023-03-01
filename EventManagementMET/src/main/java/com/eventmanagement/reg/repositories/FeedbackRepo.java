package com.eventmanagement.reg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanagement.reg.entities.Customer;
import com.eventmanagement.reg.entities.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {
	List<Feedback> findByCustomer(Customer customer);
}
