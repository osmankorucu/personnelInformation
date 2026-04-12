package com.project.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public interface Factory {

	EntityManager getEntityManager();

	EntityTransaction getEntityTransaction();

}
