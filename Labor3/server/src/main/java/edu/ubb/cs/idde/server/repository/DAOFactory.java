/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.repository;

import edu.ubb.cs.idde.server.repository.hibernate.HibernateDAOFactory;
import edu.ubb.cs.idde.server.repository.jdbc.JdbcDAOFactory;

public abstract class DAOFactory {
	public static final int JDBC = 1;
	public static final int HIBERNATE = 2;
	
	public static DAOFactory getInstance(int implementation) {
		switch (implementation) {
		case JDBC:
			return new JdbcDAOFactory();
		case HIBERNATE:
			return new HibernateDAOFactory();
		}
			
		return null;
	}
	
	public abstract UserDAO getUserDAO() throws RepositoryException;
}