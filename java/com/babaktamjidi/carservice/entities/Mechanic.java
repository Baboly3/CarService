package com.babaktamjidi.carservice.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Mechanic")
public class Mechanic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8911525082323014600L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String adress;

	@Column
	private Long phone;

	@Column
	private Long mobil;

	@Column
	private String gender;

	@Temporal(TemporalType.DATE)
	@Column
	private Date dateOfBirth;

	@Column
	private String City;

	@Column
	private String email;

	@Column
	private String state;

	@Column
	private Integer zipCode;

	@Column
	private String carBrand;

	@OneToMany(mappedBy = "mechanic")
	private Set<Service> services = new HashSet<>();

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	@Override
	public String toString() {
		return "Mechanic [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", adress=" + adress + ", phone="
				+ phone + ", mobil=" + mobil + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", City=" + City
				+ ", email=" + email + ", state=" + state + ", zipCode="
				+ zipCode + ", carBrand=" + carBrand + ", Cars=" + services + "]";
	}
}
