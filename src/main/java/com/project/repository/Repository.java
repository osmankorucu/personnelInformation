package com.project.repository;

import java.util.List;

import com.project.model.Children;
import com.project.model.EducationStatus;
import com.project.model.Personnel;

public interface Repository {

	void createPersonnel(Personnel personnel);

	void deletePersonnel(Personnel personnel);

	Personnel updatePersonnel(Personnel personnel);

	Personnel getPersonnel(int id);
	
	List<Personnel> getPersonnels();
	
	void createChildren(Children children);

	void deleteChildren(Children children);

	Children updateChildren(Children children);

	Children getChildren(int id);
	
	void createEducationStatus(EducationStatus educationStatus);

	void deleteEducationStatus(EducationStatus educationStatus);

	EducationStatus updateEducationStatus(EducationStatus educationStatus);

	EducationStatus getEducationStatus(int id);
}
