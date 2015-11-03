package com.babaktamjidi.carservice.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


public class CustomerDTO {
	
	private Long id;
	
	@Email
	private String email;
	
	@Size(min = 2, max = 50, message = "{sizeError}")
	private String firstName;
	
	@Size(min = 2, max = 50, message = "{sizeError}")
	private String lastName;

	@Size(min = 2, max = 50, message = "{sizeError}")
    private String street;
	
	@NotNull
    private Long phone;
    
	@NotNull
    private Long mobil;
    
	@NotBlank
    private String gender;

	@Size(min = 15, max=15, message = "{sizeError}") 
    private String ssn;
    
    @Size(min = 2, max = 50, message = "{sizeError}")
    private String city;

    @Size(min = 2, max = 50, message = "{sizeError}")
    private String region;
    
    @NotNull
    private Integer zip;

    @NotBlank
    private String insuranceCo;

  //------------------------------------------------------------------------------------
    
    
    
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public Long getPhone() {
		return phone;
	}


	public void setPhone(Long phone) {
		this.phone = phone;
	}


	public Long getMobil() {
		return mobil;
	}


	public void setMobil(Long mobil) {
		this.mobil = mobil;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getSsn() {
		return ssn;
	}

	
	public void setSsn(String ssn) {
			
		this.ssn = ssn;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String state) {
		this.region = state;
	}


	public Integer getZip() {
		return zip;
	}


	public void setZip(Integer zipCode) {
		this.zip = zipCode;
	}

	public String getInsuranceCo() {
		return insuranceCo;
	}


	public void setInsuranceCo(String insuranceCo) {
		this.insuranceCo = insuranceCo;
	}


	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", email=" + email + ", firstName="
				+ firstName + ", lastName=" + lastName + ", street=" + street
				+ ", phone=" + phone + ", mobil=" + mobil + ", gender="
				+ gender + ", ssn=" + ssn + ", City=" + city + ", region="
				+ region + ", zip=" + zip + ", insuranceCo=" + insuranceCo
				+ "]";
	}
	
}




    

	
