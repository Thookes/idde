/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.repository.hibernate;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import edu.ubb.cs.idde.server.model.User;
import edu.ubb.cs.idde.server.repository.RepositoryException;
import edu.ubb.cs.idde.server.repository.UserDAO;

public class HibernateUserDAO implements UserDAO{
	private final EntityManagerFactory emf;
	
	public HibernateUserDAO() throws RepositoryException {
		emf = HibernateEntityManager.getEntityManagerFactory();
	}
	
	@Override
	public List<User> getAllUsers() throws RepositoryException {
		List<User> result = new LinkedList<User>();
		EntityManager ent = null;
		try {
			ent = emf.createEntityManager();
			TypedQuery<User> query = ent.createQuery("SELECT user FROM User user", User.class);

			result = query.getResultList();
		} finally {
			ent.close();
		}
		
		return result;
	}
}
