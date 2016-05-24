/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.lab1.backend.repository;

import edu.ubb.lab1.backend.repository.jdbc.JdbcDAOFactory;

public abstract class DAOFactory {
	public static DAOFactory getInstance() {
		return new JdbcDAOFactory();
	}
	
	public abstract UserDAO getUserDAO() throws RepositoryException;
}