package com.project.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.project.repository.Repository;
import com.project.repository.impl.RepositoryImpl;

@ManagedBean
@SessionScoped
public class Controller {

	private String prsName;
	private String prsSurname;
	private String prsSex;
	private String prsDateOfBirth;
	private String prsAddress;
	private String prsEMail;
	private String prsPhoneNumber;
	private Repository repository = new RepositoryImpl();

	public String getPrsName(int id) {
		this.prsName = repository.getPersonnel(id).getPrsName();
		return this.prsName;
	}

	public void setPrsName(String prsName) {
		this.prsName = prsName;
	}

	public String getPrsSurname(int id) {
		this.prsSurname = repository.getPersonnel(id).getPrsSurname();
		return this.prsSurname;
	}

	public void setPrsSurname(String prsSurname) {
		this.prsSurname = prsSurname;
	}

	public String getPrsSex(int id) {
		this.prsSex = (repository.getPersonnel(id).isPrsSex() ? "Erkek" : "Kadın");
		return this.prsSex;
	}

	public void setPrsSex(String prsSex) {
		this.prsSex = prsSex;
	}

	public String getPrsDateOfBirth(int id) {
		this.prsDateOfBirth = repository.getPersonnel(id).getPrsDateOfBirth().toString();
		return this.prsDateOfBirth;
	}

	public void setPrsDateOfBirth(String prsDateOfBirth) {
		this.prsDateOfBirth = prsDateOfBirth;
	}

	public String getPrsAddress(int id) {
		this.prsAddress = repository.getPersonnel(id).getPrsAddress();
		return this.prsAddress;
	}

	public void setPrsAddress(String prsAddress) {
		this.prsAddress = prsAddress;
	}

	public String getPrsEMail(int id) {
		this.prsEMail = repository.getPersonnel(id).getPrsEMail();
		return this.prsEMail;
	}

	public void setPrsEMail(String prsEMail) {
		this.prsEMail = prsEMail;
	}

	public String getPrsPhoneNumber(int id) {
		this.prsPhoneNumber = repository.getPersonnel(id).getPrsPhoneNumber();
		return this.prsPhoneNumber;
	}

	public void setPrsPhoneNumber(String prsPhoneNumber) {
		this.prsPhoneNumber = prsPhoneNumber;
	}
}