package com.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "personnel")
public class Personnel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prsId;
	@Column(unique = true, length = 11)
	private String prsIDNumber;
	private String prsName;
	private String prsSurname;
	private String prsGender;
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
	private String prsIsMarried;
	@Lob
	private String prsPhoto;

	public Personnel() {
	}

	public Personnel(String prsIDNumber, String prsName, String prsSurname, String prsGender, Date prsDateOfBirth,
			String prsEMail, String prsPhoneNumber, String prsAddress, String prsIsMarried, String prsPhoto) {
		super();
		this.prsIDNumber = prsIDNumber;
		this.prsName = prsName;
		this.prsSurname = prsSurname;
		this.prsGender = prsGender;
		this.prsDateOfBirth = prsDateOfBirth;
		this.prsEMail = prsEMail;
		this.prsPhoneNumber = prsPhoneNumber;
		this.prsAddress = prsAddress;
		this.prsIsMarried = prsIsMarried;
		this.prsPhoto = prsPhoto;
	}

	public Personnel(String prsIDNumber, String prsName, String prsSurname, String prsGender, Date prsDateOfBirth,
			String prsEMail, String prsPhoneNumber, String prsAddress, List<EducationStatus> prsEducationStatus,
			List<Children> prsChildren, String prsIsMarried, String prsPhoto) {
		super();
		this.prsIDNumber = prsIDNumber;
		this.prsName = prsName;
		this.prsSurname = prsSurname;
		this.prsGender = prsGender;
		this.prsDateOfBirth = prsDateOfBirth;
		this.prsEMail = prsEMail;
		this.prsPhoneNumber = prsPhoneNumber;
		this.prsAddress = prsAddress;
		this.prsEducationStatus = prsEducationStatus;
		this.prsChildren = prsChildren;
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

	public String getPrsGender() {
		return prsGender;
	}

	public void setPrsGender(String prsGender) {
		this.prsGender = prsGender;
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

	public String getPrsIsMarried() {
		return prsIsMarried;
	}

	public void setPrsIsMarried(String prsIsMarried) {
		this.prsIsMarried = prsIsMarried;
	}

	public String getPrsPhoto() {
		return prsPhoto;
	}

	public void setPrsPhoto(String prsPhoto) {
		this.prsPhoto = prsPhoto;
	}

	public String getPrsIDNumber() {
		return prsIDNumber;
	}

	public void setPrsIDNumber(String prsIDNumber) {
		this.prsIDNumber = prsIDNumber;
	}

}
