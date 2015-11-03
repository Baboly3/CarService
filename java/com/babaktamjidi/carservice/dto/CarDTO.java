package com.babaktamjidi.carservice.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;


public class CarDTO {
	

	private Long id;

	@Temporal(TemporalType.DATE)
	private Date generation;

	@Size(min = 1, max=20, message = "{sizeError}")
	private String fuelType;

	@Size(min = 6, max=6, message = "{sizeError}")
	private String regnr;

	@Size(min = 2, max=20, message = "{sizeError}")
	private String brand;

	@Size(min = 2, max=20, message = "{sizeError}") 
	private String model;

	@Size(min = 2, max=20, message = "{sizeError}")
	private String color;

	@Min(1)
	@NotNull
	private Long mileage;

	@Size(min = 2, max=20, message = "{sizeError}")
	@NotBlank
	private String engine;
	
	private Long customerID;
	
	@Size(min = 15, max=15, message = "{sizeError}") 
	private String ssn;
	
	
//------------------------------------------------------------------------------------

	
	public Long getCustomerID() {
		return customerID;
	}


	public String getSsn() {
		return ssn;
	}


	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getGeneration() {
		return generation;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setGeneration(Date generation) {
		this.generation = generation;
	}


	public String getFuelType() {
		return fuelType;
	}


	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}


	public String getRegnr() {
		return regnr;
	}

	
	public void setRegnr(String regnr) {
		this.regnr = regnr;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public Long getMileage() {
		return mileage;
	}


	public void setMileage(Long mileage) {
		this.mileage = mileage;
	}


	public String getEngine() {
		return engine;
	}


	public void setEngine(String engine) {
		this.engine = engine;
	}
	
}
