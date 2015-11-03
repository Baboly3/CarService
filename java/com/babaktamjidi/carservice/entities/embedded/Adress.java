package com.babaktamjidi.carservice.entities.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Adress implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5630923471246436763L;

	@Column
	private String region;

	@Column
	private Integer zip;
	
	@Column
	private String street;
	
	@Column
	private String city;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zipCode) {
		this.zip = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public void setAdress(final String state, final String street, final String city, final Integer zipCode){
		setRegion(state);
		setStreet(street);
		setCity(city);
		setZip(zipCode);
 
	}

	@Override
	public String toString() {
		return "Adress [state=" + region + ", zipCode=" + zip + ", street="
				+ street + ", city=" + city + "]";
	}

	
}
