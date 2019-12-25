package com.project.factory.impl;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.project.factory.Factory;

public class FactoryImpl implements Factory {

	private EntityManager entityManager = null;
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit-01");
		this.entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}


	public EntityTransaction getEntityTransaction() {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		return entityTransaction;
	}

}
