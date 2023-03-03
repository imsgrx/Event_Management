package com.eventmanagement.reg.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanagement.reg.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	Optional<Customer> findByEmail(String email);
}
