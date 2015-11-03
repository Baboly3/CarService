package com.babaktamjidi.carservice.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

public class ServiceDTO {


	private Long id;

	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Temporal(TemporalType.DATE)
	private Date date1;

	@NotBlank
	private String note;
	
	private Long carID;
	
	private Long mechanicID;
	
	@NotBlank
	private String carRegNr;
	
	
	

	public Date getDate1() {
		return date1;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public String getCarRegNr() {
		return carRegNr;
	}

	public void setCarRegNr(String carRegNr) {
		this.carRegNr = carRegNr;
	}

	public Long getMechanicID() {
		return mechanicID;
	}

	public void setMechanicID(Long mechanicID) {
		this.mechanicID = mechanicID;
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

	public Long getCarID() {
		return carID;
	}

	public void setCarID(Long carID) {
		this.carID = carID;
	}
	
	public void serviceDTO(){
		
	}
	
	
	@Override
	public String toString() {
		return "ServiceDTO [id=" + id + ", date=" + date + ", note=" + note
				+ ", carID=" + carID + ", mechanicID=" + mechanicID
				+ ", carRegNr=" + carRegNr + "]";
	}

	public void setService(Date date, String note, Long carID, Long mechanicID){
		
		setDate(date);
		setNote(note);
		setMechanicID(mechanicID);
		setCarID(carID);
	}
}
