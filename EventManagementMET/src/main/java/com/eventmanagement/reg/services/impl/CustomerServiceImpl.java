package com.eventmanagement.reg.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagement.reg.exceptions.ResourceNotFoundException;
import com.eventmanagement.reg.entities.Customer;
import com.eventmanagement.reg.payloads.CustomerDto;
import com.eventmanagement.reg.repositories.CustomerRepo;
import com.eventmanagement.reg.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		Customer customer = this.dtoToCustomer(customerDto);
		Customer savedCustomer =  this.customerRepo.save(customer);
		return this.customerToDto(savedCustomer);
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto, Integer customerId) {
		Customer customer = this.customerRepo.findById(customerId)
				.orElseThrow(()->new ResourceNotFoundException("Customer","Id",customerId));
		
		customer.setName(customerDto.getName());	
		customer.setEmail(customerDto.getEmail());
		customer.setPassword(customerDto.getPassword());
		customer.setContactno(customerDto.getContactno());
		
		Customer updatedCustomer = this.customerRepo.save(customer);
		CustomerDto customerDto1 = this.customerToDto(updatedCustomer);
		return customerDto1;
	}

	@Override
	public CustomerDto getCustomerById(Integer customerId) {
		Customer customer = this.customerRepo.findById(customerId)
				.orElseThrow(()->new ResourceNotFoundException("Customer","Id",customerId));
		return this.customerToDto(customer);
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		
		List<Customer> customers = this.customerRepo.findAll();
		 List<CustomerDto> customerDtos = customers.stream().map(customer->this.customerToDto(customer)).collect(Collectors.toList());
		
		return  customerDtos;
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		Customer customer = this.customerRepo.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer","Id",customerId));
		this.customerRepo.delete(customer);
	}
	
	public Customer dtoToCustomer(CustomerDto customerDto) {
		Customer customer = this.modelMapper.map(customerDto, Customer.class);
		
//		customer.setId(customerDto.getId());
//		customer.setName(customerDto.getName());
//		customer.setEmail(customerDto.getEmail());
//		customer.setPassword(customerDto.getPassword());
//		customer.setContactno(customerDto.getContactno());
		return customer;
	}
	
	public CustomerDto customerToDto(Customer customer) {
		CustomerDto customerDto = this.modelMapper.map(customer, CustomerDto.class);
//		customerDto.setId(customer.getId());
//		customerDto.setName(customer.getName());
//		customerDto.setEmail(customer.getEmail());
//		customerDto.setPassword(customer.getPassword());
//		customerDto.setContactno(customer.getContactno());
		return customerDto;
	}

}
