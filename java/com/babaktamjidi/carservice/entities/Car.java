package com.babaktamjidi.carservice.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Car")
public class Car implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 7454441879361579443L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column
	private Date generation;

	@Column
	private String fuelType;

	@Column(unique = true)
	private String regnr;

	@Column
	private String brand;

	@Column
	private String model;

	@Column
	private String color;

	@Column
	private Long mileage;

	@Column
	private String engine;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date registrationDate;

	@Temporal(TemporalType.DATE)
	@Column
	private Date updatedate;
	
	@Column
	private Long customerID;
	
	@OneToMany(mappedBy="car",cascade = CascadeType.ALL, orphanRemoval = false)
	private Set<Service> service = new HashSet<>(); 
	
	@OneToMany(mappedBy="car", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<DefectReport> defectReport = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "customerID", referencedColumnName = "id", insertable = false, updatable = false)
	private Customer customer;
	

	public Car() {}
	
	public Long getCustomerID() {
		return customerID;
	}



	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}



	public Set<DefectReport> getDefectReport() {
		return defectReport;
	}

	public void setDefectReport(Set<DefectReport> defectReport) {
		this.defectReport = defectReport;
	}

	public Set<Service> getService() {
		return service;
	}

	public void setService(Set<Service> service) {
		this.service = service;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}

	@PrePersist
	public void setRegistrationDate() {
		registrationDate = new Date();
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	@PreUpdate
	public void setUpdatedate() {
		updatedate = new Date();
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

	

	

	@Override
	public String toString() {
		return "Car [id=" + id + ", generation=" + generation + ", fuelType="
				+ fuelType + ", regnr=" + regnr + ", brand=" + brand
				+ ", model=" + model + ", color=" + color + ", mileage="
				+ mileage + ", engine=" + engine + ", registrationDate="
				+ registrationDate + ", updatedate=" + updatedate
				+ ", customer=" + customer + "]";
	}

	public void setCar(Date generation, String fuelType,
			 String regnr, String brand, String model,
			 String color, Long mileage, String engine, Long customerid  ) {

		setGeneration(generation);
		setFuelType(fuelType);
		setRegnr(regnr);
		setBrand(brand);
		setModel(model);
		setColor(color);
		setMileage(mileage);
		setEngine(engine);
		setCustomerID(customerid);

	}
	
	public void update(String regnr, String Color, Long mileage){
		
		setRegnr(regnr);
		setColor(Color);
		setMileage(mileage);

}
}