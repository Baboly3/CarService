package com.babaktamjidi.carservice.services;

import java.util.List;

import com.babaktamjidi.carservice.dto.CustomerDTO;
import com.babaktamjidi.carservice.entities.Customer;

public interface CustomerService {

	void create(CustomerDTO newCustomer);
		
	List<Customer> getAll();
	
	Customer findBySSN(String ssn);
	
	Customer update(CustomerDTO updated);
	
	void delete(CustomerDTO customer);

	Long countTotalCustomers();
	
	long countServiceForFemales();
	
	long countServiceForMales();

	List<Long> countServiceByGender();


}
