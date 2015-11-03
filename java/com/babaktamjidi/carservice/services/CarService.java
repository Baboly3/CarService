package com.babaktamjidi.carservice.services;

import java.util.List;

import com.babaktamjidi.carservice.dto.CarDTO;
import com.babaktamjidi.carservice.entities.Car;

public interface CarService {

	void add(CarDTO newCar);
	
	List<Car> getAll();

	void update(CarDTO car);
	
	void delete(CarDTO car);
	
	Long countTotalCars();
}
