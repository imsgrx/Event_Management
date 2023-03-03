package com.eventmanagement.reg.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagement.reg.entities.Category;
import com.eventmanagement.reg.entities.Staff;
import com.eventmanagement.reg.exceptions.ResourceNotFoundException;
import com.eventmanagement.reg.payloads.CategoryDto;
import com.eventmanagement.reg.payloads.StaffDto;
import com.eventmanagement.reg.repositories.StaffRepo;
import com.eventmanagement.reg.services.StaffService;


@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	private StaffRepo staffRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StaffDto createStaff(StaffDto staffDto) {
		Staff staff2 = this.dtoToStaff(staffDto);
		Staff savedStaff = this.staffRepo.save(staff2);
		return this.staffToDto(savedStaff);
	}

	@Override
	public StaffDto updateStaff(StaffDto staffDto, Integer staffId) {
		Staff staff2 = this.staffRepo.findById(staffId).orElseThrow(()->new ResourceNotFoundException("Staff","Id",staffId));
		
		staff2.setStaffName(staffDto.getStaffName());
		staff2.setEmailId(staffDto.getEmailId());
		staff2.setContactNo(staffDto.getContactNo());
		staff2.setFullAddress(staffDto.getFullAddress());
		staff2.setAdhaarcardNo(staffDto.getAdhaarcardNo());
		
		Staff updatedStaff = this.staffRepo.save(staff2);
		StaffDto staffDto2 = this.staffToDto(updatedStaff);		
		return staffDto2;
	}

	@Override
	public StaffDto getStaffById(Integer staffId) {
		Staff staff = this.staffRepo.findById(staffId).orElseThrow(()->new ResourceNotFoundException("Staff","Id",staffId));
		
		return this.staffToDto(staff);
	}

	@Override
	public List<StaffDto> getAllStaff() {
		List<Staff> staffs = this.staffRepo.findAll();
		List<StaffDto> staffDtos = staffs.stream().map(staff->this.staffToDto(staff)).collect(Collectors.toList());
		
		return staffDtos;
	}

	@Override
	public void deleteStaff(Integer staffId) {
		Staff staff = this.staffRepo.findById(staffId).orElseThrow(()->new ResourceNotFoundException("Staff","Id",staffId));
		this.staffRepo.delete(staff);
		
	}
	
	
	public Staff dtoToStaff(StaffDto staffDto) {
		Staff staff = this.modelMapper.map(staffDto, Staff.class);

		return staff;
	}
	
	public StaffDto staffToDto(Staff staff) {
		StaffDto staffDto = this.modelMapper.map(staff, StaffDto.class);
		return staffDto;
	}

}
