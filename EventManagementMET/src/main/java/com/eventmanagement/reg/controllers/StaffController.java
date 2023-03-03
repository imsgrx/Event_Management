package com.eventmanagement.reg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagement.reg.payloads.ApiResponse;
import com.eventmanagement.reg.payloads.StaffDto;
import com.eventmanagement.reg.services.StaffService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	//POST - create Staff
	@PostMapping("/")
	public ResponseEntity<StaffDto> createStaff(@Valid @RequestBody StaffDto staffDto)
	{
		StaffDto createStaffDto = this.staffService.createStaff(staffDto);
		return new ResponseEntity<StaffDto>(createStaffDto,HttpStatus.CREATED);
	}
	
	//PUT update staff
	
	@PutMapping("/{staffId}")
	public ResponseEntity<StaffDto> updateStaff(@Valid @RequestBody StaffDto staffDto,@PathVariable ("staffId") Integer staffId)
	{
		StaffDto updatedStaff = this.staffService.updateStaff(staffDto, staffId);
		return ResponseEntity.ok(updatedStaff);
	}
	
	//DELETE - delete user
	@DeleteMapping("/{staffId}")
	public ResponseEntity<ApiResponse> deleteStaff(@PathVariable Integer staffId)
	{
		this.staffService.deleteStaff(staffId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Staff Deleted Successfully",true),HttpStatus.OK);
	}
	
	//GET all Staffs
	
	@GetMapping("/")
	public ResponseEntity<List<StaffDto>> getAllStaffs()
	{
		return ResponseEntity.ok(this.staffService.getAllStaff());
	}
}
