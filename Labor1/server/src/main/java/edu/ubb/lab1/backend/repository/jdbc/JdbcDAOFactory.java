/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.lab1.backend.repository.jdbc;

import edu.ubb.lab1.backend.repository.DAOFactory;
import edu.ubb.lab1.backend.repository.RepositoryException;
import edu.ubb.lab1.backend.repository.UserDAO;

public class JdbcDAOFactory extends DAOFactory {
	@Override
	public UserDAO getUserDAO() throws RepositoryException {
		return new JdbcUserDAO();
	}
}
