package com.babaktamjidi.carservice.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.babaktamjidi.carservice.dto.CarDTO;
import com.babaktamjidi.carservice.entities.Car;
import com.babaktamjidi.carservice.entities.Customer;
import com.babaktamjidi.carservice.repositories.CarRepository;
import com.babaktamjidi.carservice.repositories.CustomerRepository;
import com.babaktamjidi.carservice.services.CarService;

@Component
public class CarServiceImpl implements CarService {
	
	private CarRepository carRepository;
	private CustomerRepository customerRepository;

	@Autowired
	public CarServiceImpl(CarRepository carRepository, CustomerRepository customerRepository) {
		this.carRepository = carRepository;
		this.customerRepository = customerRepository;
	}
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void add(CarDTO newCar) {
		Car car = new Car();
	
		car.setCar(newCar.getGeneration(), newCar.getFuelType(), newCar.getRegnr(), newCar.getBrand(), 
					newCar.getModel(), newCar.getColor(), newCar.getMileage(), newCar.getEngine(), newCar.getCustomerID());

		if (newCar.getSsn() != null){
		Customer customer = customerRepository.findBySsn(newCar.getSsn());
		car.setCustomerID(customer.getId());	
		}		
		carRepository.save(car);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	@Override
	public List<Car> getAll() {
		List<Car> car = carRepository.findAll();
		return car;
	}
	@Override
	public void delete(CarDTO car) {
		System.out.println("in delete impl");
		Car remove = carRepository.findByRegnr(car.getRegnr());
		carRepository.delete(remove);
	}

	@Transactional
	@Override
	public void update(CarDTO updatedCar) {		
		Car car = carRepository.findByRegnr(updatedCar.getRegnr());	
		car.update(updatedCar.getRegnr(), updatedCar.getColor(), updatedCar.getMileage());	
	}

	@Override
	public Long countTotalCars() {	
		return carRepository.countTotalCars();
	}

}
