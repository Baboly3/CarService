package com.babaktamjidi.carservice.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity(name="Service")
public class Service implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8503771329076983389L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "ServiceDate", columnDefinition = "DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(length = 65535,columnDefinition="Text")
	private String note;
	
	@Column
	private Long carID;
	
	@Column
	private Long mechanicID;
	
	@ManyToOne(cascade = {CascadeType.PERSIST , CascadeType.REFRESH})
	@JoinColumn(name = "mechanicID", referencedColumnName = "id", insertable = false, updatable = false)
	private Mechanic mechanic;
	
	@ManyToOne 
	@JoinColumn(name = "carID", referencedColumnName = "id", insertable = false, updatable = false)
	private Car car;
	
	public Mechanic getMechanic() {
		return mechanic;
	}

	
	
	public Long getMechanicID() {
		return mechanicID;
	}



	public void setMechanicID(Long mechanicID) {
		this.mechanicID = mechanicID;
	}



	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

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
		return date;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setDate(Date date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", date=" + date + ", note=" + note
				+ ", carID=" + carID + ", mechanicID=" + mechanicID
				+ ", mechanic=" + mechanic + ", car=" + car + "]";
	}

	public void setService(Date date, String note, Long carID, Long mechanicID){
		
		setDate(date);
		setNote(note);
		setMechanicID(mechanicID);
		setCarID(carID);
		
		
	}
	
}


