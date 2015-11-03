package com.babaktamjidi.carservice.validators;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.babaktamjidi.carservice.dto.ServiceDTO;
import com.babaktamjidi.carservice.entities.Service;
import com.babaktamjidi.carservice.repositories.ServiceRepository;

@Component
public class ServiceValidate extends LocalValidatorFactoryBean {

	ServiceRepository serviceRepository;

	@Resource
	public void setServiceRepository(ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(ServiceDTO.class);
	}
	
	@Override
	public void validate(Object target, Errors errors, Object... args) {
		
		super.validate(target, errors, args);
		

		if(!errors.hasErrors()) {
			ServiceDTO serviceDTO = (ServiceDTO) target;
			

			String car = serviceRepository.getCar(serviceDTO.getCarRegNr());
			
			System.out.println("regnr: " + car);
			
			if(car == null){
				
				errors.rejectValue("carRegNr", "CarNotFound");
			}
		}
	}
}
			

	
