/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.repository.hibernate;

import edu.ubb.cs.idde.server.repository.DAOFactory;
import edu.ubb.cs.idde.server.repository.RepositoryException;
import edu.ubb.cs.idde.server.repository.UserDAO;

public class HibernateDAOFactory extends DAOFactory {

	@Override
	public UserDAO getUserDAO() throws RepositoryException {
		return new HibernateUserDAO();
	}

}
