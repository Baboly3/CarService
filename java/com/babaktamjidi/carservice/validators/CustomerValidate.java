package com.babaktamjidi.carservice.validators;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.babaktamjidi.carservice.dto.CustomerDTO;
import com.babaktamjidi.carservice.entities.Customer;
import com.babaktamjidi.carservice.repositories.CustomerRepository;

@Component
public class CustomerValidate extends LocalValidatorFactoryBean {

	CustomerRepository customerRepository;
	
	@Resource
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(CustomerDTO.class);
	}
	
	@Override
	public void validate(Object target, Errors errors, Object... args) {
		
		super.validate(target, errors, args);
		
		if(!errors.hasErrors()) {
//			CustomerDTO customerDTO = (CustomerDTO) target;
//			Customer test1 = customerRepository.findBySsn(customerDTO.getSsn());
//			Customer test2 = customerRepository.findByEmail(customerDTO.getEmail());
//			Customer test3 = customerRepository.findByMobil(customerDTO.getMobil());
//			
//			if(test1 != null) {
//				
//				errors.rejectValue("ssn", "ssnExist");
//			}
//			if(test2 != null){
//				
//				errors.rejectValue("email", "emailExist");
//			}
//			if(test3 != null){
//				errors.rejectValue("mobil", "mobilExist");
//			}

		}
	}
}
