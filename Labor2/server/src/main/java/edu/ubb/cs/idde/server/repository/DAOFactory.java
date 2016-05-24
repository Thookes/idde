/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.repository;

import edu.ubb.cs.idde.server.repository.jdbc.JdbcDAOFactory;

public abstract class DAOFactory {
	public static DAOFactory getInstance() {
		return new JdbcDAOFactory();
	}
	
	public abstract UserDAO getUserDAO() throws RepositoryException;
}