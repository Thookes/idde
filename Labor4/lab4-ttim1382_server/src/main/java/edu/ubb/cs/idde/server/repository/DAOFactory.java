/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.repository;

import edu.ubb.cs.idde.server.repository.RepositoryException;
import edu.ubb.cs.idde.server.repository.UserDAO;
import edu.ubb.cs.idde.server.repository.jdbc.JdbcDAOFactory;

public abstract class DAOFactory {
	public static final int JDBC = 1;
	
	public static DAOFactory getInstance(int implementation) {
		switch (implementation) {
		case JDBC:
			return new JdbcDAOFactory();
		}
		
		return null;
	}
	
	public abstract UserDAO getUserDAO() throws RepositoryException;
}