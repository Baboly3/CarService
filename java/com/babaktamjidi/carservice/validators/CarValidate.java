package com.babaktamjidi.carservice.validators;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.babaktamjidi.carservice.dto.CarDTO;
import com.babaktamjidi.carservice.entities.Car;
import com.babaktamjidi.carservice.repositories.CarRepository;

@Component
public class CarValidate extends LocalValidatorFactoryBean {
	
	CarRepository carRepository;

	@Resource
	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;	
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(CarDTO.class);
	}
	
	@Override
	public void validate(Object target, Errors errors, Object... args) {
		
		super.validate(target, errors, args);
		
		if(!errors.hasErrors()) {
			CarDTO carDTO = (CarDTO) target;
			
			Car exist = carRepository.findByRegnr(carDTO.getRegnr());
			String ssnExist = carRepository.getCustomer(carDTO.getSsn());
			
			
			if(exist != null) {
				
				errors.rejectValue("regnr", "regExist");
			}
			
			if(ssnExist == null){
				
				errors.rejectValue("ssn", "ssnNotFound");
			}
		}
	}
}


