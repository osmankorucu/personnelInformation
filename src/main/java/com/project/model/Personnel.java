package com.project.model;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "personnel")
public class Personnel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prsId;
	private String prsName;
	private String prsSurname;
	private boolean prsSex; // "true" for male, "false" for female;
	@Temporal(TemporalType.DATE)
	private Date prsDateOfBirth;
	private String prsEMail;
	private String prsPhoneNumber;
	@Lob
	private String prsAddress;
	@OneToMany(cascade = CascadeType.ALL)
	private List<EducationStatus> prsEducationStatus = new ArrayList<EducationStatus>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<Children> prsChildren = new ArrayList<Children>();
	private boolean prsIsMarried;
	@Lob
	private Base64 prsPhoto;

	public Personnel() {
	}

	public Personnel(String prsName, String prsSurname, boolean prsSex, Date prsDateOfBirth, String prsEMail,
			String prsPhoneNumber, String prsAddress, boolean prsIsMarried, Base64 prsPhoto) {
		super();
		this.prsName = prsName;
		this.prsSurname = prsSurname;
		this.prsSex = prsSex;
		this.prsDateOfBirth = prsDateOfBirth;
		this.prsEMail = prsEMail;
		this.prsPhoneNumber = prsPhoneNumber;
		this.prsAddress = prsAddress;
		this.prsIsMarried = prsIsMarried;
		this.prsPhoto = prsPhoto;
	}
	
	public void addChildren(Children child) {
		prsChildren.add(child);
	}
	public void addEducationStatus(EducationStatus educationStatus) {
		prsEducationStatus.add(educationStatus);
	}

	public int getPrsId() {
		return prsId;
	}

	public void setPrsId(int prsId) {
		this.prsId = prsId;
	}

	public String getPrsName() {
		return prsName;
	}

	public void setPrsName(String prsName) {
		this.prsName = prsName;
	}

	public String getPrsSurname() {
		return prsSurname;
	}

	public void setPrsSurname(String prsSurname) {
		this.prsSurname = prsSurname;
	}

	public boolean isPrsSex() {
		return prsSex;
	}

	public void setPrsSex(boolean prsSex) {
		this.prsSex = prsSex;
	}

	public Date getPrsDateOfBirth() {
		return prsDateOfBirth;
	}

	public void setPrsDateOfBirth(Date prsDateOfBirth) {
		this.prsDateOfBirth = prsDateOfBirth;
	}

	public String getPrsEMail() {
		return prsEMail;
	}

	public void setPrsEMail(String prsEMail) {
		this.prsEMail = prsEMail;
	}

	public String getPrsPhoneNumber() {
		return prsPhoneNumber;
	}

	public void setPrsPhoneNumber(String prsPhoneNumber) {
		this.prsPhoneNumber = prsPhoneNumber;
	}

	public String getPrsAddress() {
		return prsAddress;
	}

	public void setPrsAddress(String prsAddress) {
		this.prsAddress = prsAddress;
	}

	public List<EducationStatus> getPrsEducationStatus() {
		return prsEducationStatus;
	}

	public void setPrsEducationStatus(List<EducationStatus> prsEducationStatus) {
		this.prsEducationStatus = prsEducationStatus;
	}

	public List<Children> getPrsChildren() {
		return prsChildren;
	}

	public void setPrsChildren(List<Children> prsChildren) {
		this.prsChildren = prsChildren;
	}

	public boolean isPrsIsMarried() {
		return prsIsMarried;
	}

	public void setPrsIsMarried(boolean prsIsMarried) {
		this.prsIsMarried = prsIsMarried;
	}

	public Base64 getPrsPhoto() {
		return prsPhoto;
	}

	public void setPrsPhoto(Base64 prsPhoto) {
		this.prsPhoto = prsPhoto;
	}

}
