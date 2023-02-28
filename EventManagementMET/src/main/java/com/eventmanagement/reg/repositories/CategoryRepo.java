package com.eventmanagement.reg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanagement.reg.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
}
