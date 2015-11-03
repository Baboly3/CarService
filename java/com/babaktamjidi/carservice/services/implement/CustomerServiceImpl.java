package com.babaktamjidi.carservice.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.babaktamjidi.carservice.dto.CustomerDTO;
import com.babaktamjidi.carservice.entities.Customer;
import com.babaktamjidi.carservice.entities.embedded.Adress;
import com.babaktamjidi.carservice.repositories.CustomerRepository;
import com.babaktamjidi.carservice.services.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {	
		this.customerRepository = customerRepository;
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void create(CustomerDTO newCustomer) {

		Customer customer = new Customer();
		Adress adress = new Adress();
		
		adress.setAdress(newCustomer.getRegion(), newCustomer.getStreet(), newCustomer.getCity(), newCustomer.getZip());
		customer.setCustomer(newCustomer.getFirstName(), newCustomer.getLastName(), adress, newCustomer.getPhone(), 
						     newCustomer.getMobil(), newCustomer.getEmail(), newCustomer.getInsuranceCo(), 
						     newCustomer.getGender(), newCustomer.getSsn());
		customerRepository.save(customer);
	}

	@Transactional
	@Override
	public List<Customer> getAll() {
		List<Customer> customer = new ArrayList<Customer>();
		customer = customerRepository.findAll();
		return customer;
	}

	public Customer Save(Customer customer) {
		customerRepository.save(customer);
		return customer;
	}

	@Transactional(readOnly = true)
	@Override
	public Customer findBySSN(String ssn){
		Customer customer = customerRepository.findBySsn(ssn);
		return customer;
	}

	@Transactional
	@Override
	public Customer update(CustomerDTO updatedCustomer) {
		Adress adress = new Adress();	
		Customer customer = customerRepository.findBySsn(updatedCustomer.getSsn());	
		
		adress.setAdress(updatedCustomer.getStreet(), updatedCustomer.getStreet(), updatedCustomer.getCity(), updatedCustomer.getZip());
		customer.updateCustomer(adress, updatedCustomer.getMobil(), updatedCustomer.getPhone(), 
								updatedCustomer.getEmail(),updatedCustomer.getInsuranceCo());
		return customer;
		
	}

	@Override
	public void delete(CustomerDTO c) {
		Customer customer = customerRepository.findOne(c.getId());
		customerRepository.delete(customer);			
	}
	@Override
	public Long countTotalCustomers() {
		return customerRepository.countTotalCustomers();
	}
	@Override
	public long countServiceForFemales() {	
		return customerRepository.CountServiceForFemales();
	}
	@Override
	public long countServiceForMales() {
		return customerRepository.CountServiceForMales();
	}
	@Transactional(readOnly = true)
	@Override
	public List<Long> countServiceByGender() {
		List<Long> gender = new ArrayList<Long>();
		gender.add(0, countServiceForFemales());
		gender.add(1, countServiceForMales());
		return gender;
	}
}