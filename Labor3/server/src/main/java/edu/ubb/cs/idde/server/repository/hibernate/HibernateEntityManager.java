/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.repository.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateEntityManager {
	private static EntityManagerFactory entityManagerFactory;
	
	private static final Logger LOG = LoggerFactory.getLogger(HibernateEntityManager.class);
	
	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("user");
		} catch (Throwable e) {
			LOG.error("EntityManagerFactory: " + e, e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
}
