package com.eventmanagement.reg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanagement.reg.entities.Staff;

public interface StaffRepo extends JpaRepository<Staff, Integer>{

}
