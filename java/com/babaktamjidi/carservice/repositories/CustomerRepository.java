package com.babaktamjidi.carservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.babaktamjidi.carservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	void delete(Long id);

	Customer findBySsn(String ssn);
	
	Customer findByMobil(Long mobil);

	Customer findByEmail(String email);

	@Query("select count(c) from Customer c")
	long countTotalCustomers();
	
	
	@Query(value = "SELECT SUM(Customer.gender = 'female') AS female FROM Customer INNER JOIN Car ON Car.customerid = Customer.id INNER JOIN Service ON Service.carid = Car.id",  nativeQuery = true)	
	long CountServiceForFemales();
	
	@Query(value = "SELECT SUM(Customer.gender = 'male') AS male FROM Customer INNER JOIN Car ON Car.customerid = Customer.id INNER JOIN Service ON Service.carid = Car.id",  nativeQuery = true)	
	long CountServiceForMales();

	
}
