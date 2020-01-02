package com.project.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.project.model.util.EducationType;

@Entity(name = "educationstatus")
public class EducationStatus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int esId;
	private String esName;
	private String esCity;
	@Temporal(TemporalType.DATE)
	private Date esStartDate;
	@Temporal(TemporalType.DATE)
	private Date esGraduatedDate;
	private EducationType esType;

	public EducationStatus() {
	}

	public EducationStatus(String esName, String esCity, Date esStartDate, Date esGraduatedDate, EducationType esType) {
		super();
		this.esName = esName;
		this.esCity = esCity;
		this.esStartDate = esStartDate;
		this.esGraduatedDate = esGraduatedDate;
		this.esType = esType;
	}

	public int getEsId() {
		return esId;
	}

	public void setEsId(int esId) {
		this.esId = esId;
	}

	public String getEsName() {
		return esName;
	}

	public void setEsName(String esName) {
		this.esName = esName;
	}

	public String getEsCity() {
		return esCity;
	}

	public void setEsCity(String esCity) {
		this.esCity = esCity;
	}

	public Date getEsStartDate() {
		return esStartDate;
	}

	public void setEsStartDate(Date esStartDate) {
		this.esStartDate = esStartDate;
	}

	public Date getEsGraduatedDate() {
		return esGraduatedDate;
	}

	public void setEsGraduatedDate(Date esGraduatedDate) {
		this.esGraduatedDate = esGraduatedDate;
	}

	public EducationType getEsType() {
		return esType;
	}

	public void setEsType(EducationType esType) {
		this.esType = esType;
	}

}
