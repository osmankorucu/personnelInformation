package com.project.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import com.project.factory.impl.FactoryImpl;
import com.project.model.Children;
import com.project.model.EducationStatus;
import com.project.model.Personnel;
import com.project.repository.Repository;

public class RepositoryImpl implements Repository {

	private FactoryImpl factoryImpl = new FactoryImpl();
	private EntityManager entityManager = factoryImpl.getEntityManager();
	private EntityTransaction entityTransaction = factoryImpl.getEntityTransaction();

	public void createPersonnel(Personnel personnel) {
		this.entityTransaction.begin();
		this.entityManager.persist(personnel);
		this.entityTransaction.commit();
	}

	public void deletePersonnel(Personnel personnel) {
		this.entityTransaction.begin();
		this.entityManager.remove(personnel);
		this.entityTransaction.commit();
	}

	public Personnel updatePersonnel(Personnel personnel) {
		this.entityTransaction.begin();
		Personnel updatedPersonnel = this.entityManager.merge(personnel);
		this.entityTransaction.commit();
		return updatedPersonnel;
	}

	public Personnel getPersonnel(int id) {
		Personnel findedPersonnel = entityManager.find(Personnel.class, id);
		if (findedPersonnel != null)
			return findedPersonnel;
		return null;
	}

	public void createChildren(Children children) {
		this.entityTransaction.begin();
		this.entityManager.persist(children);
		this.entityTransaction.commit();

	}

	public void deleteChildren(Children children) {
		this.entityTransaction.begin();
		this.entityManager.remove(children);
		this.entityTransaction.commit();
	}

	public Children updateChildren(Children children) {
		this.entityTransaction.begin();
		Children updatedChildren = this.entityManager.merge(children);
		this.entityTransaction.commit();
		return updatedChildren;
	}

	public Children getChildren(int id) {
		Children findedChildren = entityManager.find(Children.class, id);
		if (findedChildren != null)
			return findedChildren;
		return null;
	}

	public void createEducationStatus(EducationStatus educationStatus) {
		this.entityTransaction.begin();
		this.entityManager.persist(educationStatus);
		this.entityTransaction.commit();

	}

	public void deleteEducationStatus(EducationStatus educationStatus) {
		this.entityTransaction.begin();
		this.entityManager.remove(educationStatus);
		this.entityTransaction.commit();
	}

	public EducationStatus updateEducationStatus(EducationStatus educationStatus) {
		this.entityTransaction.begin();
		EducationStatus updatedEducationStatus = this.entityManager.merge(educationStatus);
		this.entityTransaction.commit();
		return updatedEducationStatus;
	}

	public EducationStatus getEducationStatus(int id) {
		EducationStatus findedEducationStatus = entityManager.find(EducationStatus.class, id);
		if (findedEducationStatus != null)
			return findedEducationStatus;
		return null;
	}

	public List<Personnel> getPersonnels() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Personnel> cq = cb.createQuery(Personnel.class);
		Root<Personnel> rootEntry = cq.from(Personnel.class);
		CriteriaQuery<Personnel> all = cq.select(rootEntry);
		TypedQuery<Personnel> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}
	
	public List<Number> getPersonnelGenderData() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		 CriteriaQuery<Personnel> q = cb.createQuery(Personnel.class);
		  Root<Personnel> c = q.from(Personnel.class);
		  q.select(c);
		  ParameterExpression<Integer> p = cb.parameter(Integer.class);
		  q.where(cb.gt(c.get("population"), p));
	}
}
