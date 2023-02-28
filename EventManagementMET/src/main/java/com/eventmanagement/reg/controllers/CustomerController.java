package com.eventmanagement.reg.controllers;

import java.util.List;
import java.util.Map;

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
import com.eventmanagement.reg.payloads.CustomerDto;
import com.eventmanagement.reg.services.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	//POST - create user
	@PostMapping("/")
	public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto)
	{
		CustomerDto createCustomerDto = this.customerService.createCustomer(customerDto);
		return new ResponseEntity<CustomerDto>(createCustomerDto,HttpStatus.CREATED);
	}
	
	//PUT - update user
	@PutMapping("/{customerId}")                //{customerID}-->path uri variable
	public ResponseEntity<CustomerDto> updateCustomer(@Valid @RequestBody CustomerDto customerDto,@PathVariable("customerId") Integer cid)
	{
		CustomerDto updatedCustomer = this.customerService.updateCustomer(customerDto, cid);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	
	//DELETE - delete user
	@DeleteMapping("/{customerId}")
	public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable Integer customerId)
	{
		this.customerService.deleteCustomer(customerId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true),HttpStatus.OK);
	}
	
	
	//GET - users get	
	@GetMapping("/")
	public ResponseEntity<List<CustomerDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.customerService.getAllCustomers());
	}
	
	//GET - get single user	
		@GetMapping("/{customerId}")
		public ResponseEntity<CustomerDto> getSingleUsers(@PathVariable Integer customerId)
		{
			return ResponseEntity.ok(this.customerService.getCustomerById(customerId));
		}
	
}
