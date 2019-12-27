package com.project.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class Bean {
	public void myActionMethod(){}
	public String navigateToPage() {
		return "newPersonnelAdd?faces-redirect=true";
	}
}
