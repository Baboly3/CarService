package com.babaktamjidi.carservice.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.babaktamjidi.carservice.entities.embedded.Adress;


@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7942753752623126418L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true, nullable = false)
	private String ssn;
	
	@Column(nullable = false)
	String firstName;
	
	@Column(nullable = false)
	String lastName;
	
	@Embedded
	private Adress adress;
	
	@Column
	private Long phone;
	
	@Column(unique=true)
	private Long mobil;
	
	@Column(unique=true)
	private String email;
	
	@Column(nullable=false)
	private String insuranceCo;

	@Column(nullable=false)
	private String gender;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date registrationDate;

	@Temporal(TemporalType.DATE)
	@Column
	private Date updatedate;
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Car> car = new HashSet<>(); 
	
	public Customer() {}

	public Set<Car> getCar() {
		return car;
	}
	
	public void setCar(Set<Car> car) {
		this.car = car;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	@PrePersist
	@DateTimeFormat(pattern="yyyy-MM-dd")
	protected void RegistrationDate() {
		registrationDate = new Date();
	}

	@PreUpdate
	@DateTimeFormat(pattern="yyyy-MM-dd")
	protected void Updatedate() {
		updatedate = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
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

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInsuranceCo() {
		return insuranceCo;
	}

	public void setInsuranceCo(String insuranceCo) {
		this.insuranceCo = insuranceCo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", ssn=" + ssn + ", firstName="
				+ firstName + ", lastName=" + lastName + ", adress=" + adress
				+ ", phone=" + phone + ", mobil=" + mobil + ", email=" + email
				+ ", insuranceCo=" + insuranceCo + ", gender=" + gender
				+ ", registrationDate=" + registrationDate + ", updatedate="
				+ updatedate + "]";
	}

	public void setCustomer(String firstName, String LastName, Adress adress, Long phone, Long mobil, String email, String insuranceCo, String gender ,String ssn){	
		setAdress(adress);
		setFirstName(firstName);
		setLastName(LastName);
		setPhone(phone);
		setMobil(mobil);
		setEmail(email);
		setSsn(ssn);
		setGender(gender);
		setInsuranceCo(insuranceCo);
		
	}
	
	public void updateCustomer(Adress adress, Long mobil, Long phone, String email, String insuranceCo ){
		setAdress(adress);
		setMobil(mobil);
		setPhone(phone);
		setEmail(email);
		setInsuranceCo(insuranceCo);
	}
}