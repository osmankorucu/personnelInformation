package com.project.repository.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;

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
		List<Number> numbers = new ArrayList<Number>();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Personnel> cq = cb.createQuery(Personnel.class);
		Root<Personnel> r = cq.from(Personnel.class);
		CriteriaQuery<Personnel> male = cq.select(r).where(cb.equal(r.get("prsGender"), "Erkek"));
		TypedQuery<Personnel> result = entityManager.createQuery(male);
		numbers.add(result.getResultList().size());
		CriteriaQuery<Personnel> female = cq.select(r).where(cb.equal(r.get("prsGender"), "Kadın"));
		TypedQuery<Personnel> result2 = entityManager.createQuery(female);
		numbers.add(result2.getResultList().size());
		return numbers;
	}

	public List<Number> getPersonnelAgeData() {
		Calendar cal;
		List<Number> numbers = new ArrayList<Number>();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Personnel> cq = cb.createQuery(Personnel.class);
		Root<Personnel> r = cq.from(Personnel.class);

		cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -18);
		Date date18 = cal.getTime();
		CriteriaQuery<Personnel> child = cq.select(r).where(cb.between(r.get("prsDateOfBirth"), date18, new Date()));
		TypedQuery<Personnel> result = entityManager.createQuery(child);
		int childNum = result.getResultList().size();
		numbers.add(childNum);

		cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -30);
		Date date30 = cal.getTime();
		CriteriaQuery<Personnel> young = cq.select(r).where(cb.between(r.get("prsDateOfBirth"), date30, date18));
		TypedQuery<Personnel> result2 = entityManager.createQuery(young);
		int youngNum = result2.getResultList().size();
		numbers.add(youngNum);

		cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -50);
		Date date50 = cal.getTime();
		CriteriaQuery<Personnel> middleAged = cq.select(r).where(cb.between(r.get("prsDateOfBirth"), date50, date30));
		TypedQuery<Personnel> result3 = entityManager.createQuery(middleAged);
		int middleAgedNum = result3.getResultList().size();
		numbers.add(middleAgedNum);

		int old = getPersonnels().size() - (childNum + youngNum + middleAgedNum);
		numbers.add(old);
		return numbers;
	}
}
