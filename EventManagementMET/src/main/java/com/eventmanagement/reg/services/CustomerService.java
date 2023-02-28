package com.eventmanagement.reg.services;
import java.util.List;

import com.eventmanagement.reg.payloads.CustomerDto;

public interface CustomerService {

	CustomerDto createCustomer(CustomerDto customer);
	CustomerDto updateCustomer(CustomerDto customer,Integer customerId);
	CustomerDto getCustomerById(Integer customerId);
	List<CustomerDto> getAllCustomers();
	
	void deleteCustomer(Integer customerId);
}
