package com.project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "children")
public class Children {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chdID;
	private String chdName;
	private String chdSurname;
	private boolean chdSex; // "true" for male, "false" for female;
	@Temporal(TemporalType.DATE)
	private Date chdDateOfBirth;

	public Children() {
	}

	public Children(String chdName, String chdSurname, boolean chdSex, Date chdDateOfBirth) {
		super();
		this.chdName = chdName;
		this.chdSurname = chdSurname;
		this.chdSex = chdSex;
		this.chdDateOfBirth = chdDateOfBirth;
	}

	public int getChdID() {
		return chdID;
	}

	public void setChdID(int chdID) {
		this.chdID = chdID;
	}

	public String getChdName() {
		return chdName;
	}

	public void setChdName(String chdName) {
		this.chdName = chdName;
	}

	public boolean isChdSex() {
		return chdSex;
	}

	public void setChdSex(boolean chdSex) {
		this.chdSex = chdSex;
	}

	public Date getChdDateOfBirth() {
		return chdDateOfBirth;
	}

	public void setChdDateOfBirth(Date chdDateOfBirth) {
		this.chdDateOfBirth = chdDateOfBirth;
	}

	public String getChdSurname() {
		return chdSurname;
	}

	public void setChdSurname(String chdSurname) {
		this.chdSurname = chdSurname;
	}

}
