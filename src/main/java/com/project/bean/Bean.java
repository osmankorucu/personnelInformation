package com.project.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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

	List<Personnel> personnels;

	@PostConstruct
	public void init() {
		System.out.println("içerde");
		Repository repository = new RepositoryImpl();
		personnels = repository.getPersonnels();
		
	}

	public static Date createDate(int day, int month, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		return calendar.getTime();
	}

	public List<Personnel> getPersonnels() {
		return personnels;
	}

	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = personnels;
	}

	public String navigateToNewPersonnelAdd() {
		return "newPersonnelAdd?faces-redirect=true";
	}

	public String navigateToPersonnelList() {
		return "personnelList?faces-redirect=true";
	}

	public String navigateToInfoGraphic() {
		return "infoGraphic?faces-redirect=true";
	}

	public String navigateToIndex() {
		return "index?faces-redirect=true";
	}
}
