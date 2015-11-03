package com.babaktamjidi.carservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.babaktamjidi.carservice.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	
	Car findByRegnr(String regnr);
	
	@Query("select count(c) from Car c")
	Long countTotalCars();

	@Query("SELECT ssn FROM Customer c where c.ssn = :ssn")
	String getCustomer(@Param("ssn") String ssn);
}
