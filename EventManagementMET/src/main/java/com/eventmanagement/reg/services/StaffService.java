package com.eventmanagement.reg.services;

import com.eventmanagement.reg.payloads.StaffDto;

public interface StaffService {
	//create
	StaffDto createStaff(StaffDto staff);
	
	//update
	StaffDto updateStaff(StaffDto staff,Integer staffId);
	
	//get staff by id
	StaffDto getStaffById(Integer staffId);
	
	//get all staff
	java.util.List<StaffDto> getAllStaff();
	
	//delete
	void deleteStaff(Integer staffId);
}
