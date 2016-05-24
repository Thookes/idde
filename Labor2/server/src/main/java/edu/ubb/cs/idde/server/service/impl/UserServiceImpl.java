/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.cs.idde.server.model.User;
import edu.ubb.cs.idde.server.repository.DAOFactory;
import edu.ubb.cs.idde.server.repository.RepositoryException;
import edu.ubb.cs.idde.server.service.ServiceException;
import edu.ubb.cs.idde.server.service.UserService;

public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> getAllUsers() throws ServiceException {
		try {
			return (DAOFactory.getInstance()).getUserDAO().getAllUsers();
		} catch (RepositoryException e) {
			LOG.error(e.getMessage());
			throw new ServiceException("RepositoryException: " + e.getMessage());
		}
	}
}
