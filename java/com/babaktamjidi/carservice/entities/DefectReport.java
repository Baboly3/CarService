package com.babaktamjidi.carservice.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name="DefectReport")
public class DefectReport implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2210406350135376271L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "accidentDate", columnDefinition = "DATETIME")
	private Date accidentDate;
	
	@Column(length = 65535,columnDefinition="Text")
	private String description;
	
	@Column(length = 65535,columnDefinition="Text")
	private String note;
	
	@Column
	private Long carID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carID", referencedColumnName = "id", insertable = false, updatable = false)
	private Car car; 
	

	public Long getCarID() {
		return carID;
	}
	
	public void setCarID(Long carID) {
		this.carID = carID;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return accidentDate;
	}

	public void setDate(Date accidentdate) {
		this.accidentDate = accidentdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
