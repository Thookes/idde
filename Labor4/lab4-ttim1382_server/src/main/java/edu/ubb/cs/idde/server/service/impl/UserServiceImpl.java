/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.cs.idde.interfce.model.User;
import edu.ubb.cs.idde.interfce.service.ServiceException;
import edu.ubb.cs.idde.interfce.service.UserService;
import edu.ubb.cs.idde.server.repository.DAOFactory;
import edu.ubb.cs.idde.server.repository.RepositoryException;

public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<User> getAllUsers() throws ServiceException {
		try {
			return (List)DAOFactory.getInstance(DAOFactory.JDBC).getUserDAO().getAllUsers();
		} catch (RepositoryException e) {
			LOG.error(e.getMessage());
			throw new ServiceException("RepositoryException: " + e.getMessage());
		}
	}
}
