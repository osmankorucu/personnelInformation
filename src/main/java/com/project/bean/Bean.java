package com.project.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

import com.project.model.Children;
import com.project.model.EducationStatus;
import com.project.model.Personnel;
import com.project.repository.Repository;
import com.project.repository.impl.RepositoryImpl;

@ManagedBean
@ViewScoped
public class Bean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String navigateTo;
	private List<Personnel> personnels;
	private List<Personnel> filteredPersonnels;

	private int newPrsId;
	private String newPrsName;
	private String newPrsSurname;
	private String newPrsSex; // "true" for male, "false" for female;
	private Date newPrsDateOfBirth;
	private String newPrsEMail;
	private String newPrsPhoneNumber;
	private String newPrsAddress;
	private List<EducationStatus> newPrsEducationStatus = new ArrayList<EducationStatus>();
	private List<Children> newPrsChildren = new ArrayList<Children>();
	private String newPrsIsMarried;
	private String base64Image;
	private Personnel newPersonnel;

	Repository repository = new RepositoryImpl();

	@PostConstruct
	public void init() {
		readDB();
	}

	public void onUploadImage(FileUploadEvent event) {
		String fileName = event.getFile().getFileName();
		// Get file extension.
		String extension = "png";
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1).toLowerCase();
		}
		String encodedImage = java.util.Base64.getEncoder().encodeToString(event.getFile().getContents());
		this.base64Image = String.format("data:image/%s;base64,%s", extension, encodedImage);
	}

	public String creatorNewPersonnel() {
		String message;
		try {
			newPersonnel = new Personnel(newPrsName, newPrsSurname, newPrsSex, newPrsDateOfBirth, newPrsEMail,
					newPrsPhoneNumber, newPrsAddress, newPrsIsMarried, null);
			repository.createPersonnel(newPersonnel);
			clearTempPrsData();
			message = "Ekleme işlemi Başarılı";
			return message;
		} catch (Exception e) {
			message = "Ekleme işlemi Başarısız";
			return message;
		}
	}

	public String deletePersonnel(Personnel personnel) {
		String message;
		try {
			repository.deletePersonnel(personnel);
			message = "Silme işlemi Başarılı";
			readDB();
			return message;

		} catch (Exception e) {
			message = "Silme işlemi Başarısız";
			readDB();
			return message;
		}
	}

	private void clearTempPrsData() {
		newPrsName = "";
		newPrsSurname = "";
		newPrsSex = "";
		newPrsEMail = "";
		newPrsPhoneNumber = "";
		newPrsAddress = "";
		newPrsIsMarried = "";
		newPrsDateOfBirth = new Date();
	}

	private void readDB() {
		personnels = repository.getPersonnels();
	}

	public List<Personnel> getFilteredPersonnels() {
		return filteredPersonnels;
	}

	public void setFilteredPersonnels(List<Personnel> filteredPersonnels) {
		this.filteredPersonnels = filteredPersonnels;
	}

	public String getNavigateTo() {
		return navigateTo;
	}

	public void setNavigateTo(String navigateTo) {
		this.navigateTo = navigateTo;
	}

	public List<Personnel> getPersonnels() {
		return personnels;
	}

	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = personnels;
	}

	public int getNewPrsId() {
		return newPrsId;
	}

	public void setNewPrsId(int newPrsId) {
		this.newPrsId = newPrsId;
	}

	public String getNewPrsName() {
		return newPrsName;
	}

	public void setNewPrsName(String newPrsName) {
		this.newPrsName = newPrsName;
	}

	public String getNewPrsSurname() {
		return newPrsSurname;
	}

	public void setNewPrsSurname(String newPrsSurname) {
		this.newPrsSurname = newPrsSurname;
	}

	public String getNewPrsSex() {
		return newPrsSex;
	}

	public void setNewPrsSex(String newPrsSex) {
		this.newPrsSex = newPrsSex;
	}

	public Date getNewPrsDateOfBirth() {
		return newPrsDateOfBirth;
	}

	public void setNewPrsDateOfBirth(Date newPrsDateOfBirth) {
		this.newPrsDateOfBirth = newPrsDateOfBirth;
	}

	public String getNewPrsEMail() {
		return newPrsEMail;
	}

	public void setNewPrsEMail(String newPrsEMail) {
		this.newPrsEMail = newPrsEMail;
	}

	public String getNewPrsPhoneNumber() {
		return newPrsPhoneNumber;
	}

	public void setNewPrsPhoneNumber(String newPrsPhoneNumber) {
		this.newPrsPhoneNumber = newPrsPhoneNumber;
	}

	public String getNewPrsAddress() {
		return newPrsAddress;
	}

	public void setNewPrsAddress(String newPrsAddress) {
		this.newPrsAddress = newPrsAddress;
	}

	public List<EducationStatus> getNewPrsEducationStatus() {
		return newPrsEducationStatus;
	}

	public void setNewPrsEducationStatus(List<EducationStatus> newPrsEducationStatus) {
		this.newPrsEducationStatus = newPrsEducationStatus;
	}

	public List<Children> getNewPrsChildren() {
		return newPrsChildren;
	}

	public void setNewPrsChildren(List<Children> newPrsChildren) {
		this.newPrsChildren = newPrsChildren;
	}

	public String getNewPrsIsMarried() {
		return newPrsIsMarried;
	}

	public void setNewPrsIsMarried(String newPrsIsMarried) {
		this.newPrsIsMarried = newPrsIsMarried;
	}

	public String getNewPrsPhoto() {
		return base64Image;
	}

	public void setNewPrsPhoto(String newPrsPhoto) {
		this.base64Image = newPrsPhoto;
	}

	public String navigateToNewPersonnelAdd() {
		navigateTo = "newPersonnelAdd?faces-redirect=true";
		return navigateTo;
	}

	public String navigateToPersonnelList() {
		navigateTo = "personnelList?faces-redirect=true";
		return navigateTo;
	}

	public String navigateToInfoGraphic() {
		navigateTo = "infoGraphic?faces-redirect=true";
		return navigateTo;
	}

	public String navigateToIndex() {
		navigateTo = "index?faces-redirect=true";
		return navigateTo;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public Personnel getNewPersonnel() {
		return newPersonnel;
	}

	public void setNewPersonnel(Personnel newPersonnel) {
		this.newPersonnel = newPersonnel;
	}

}
