/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.service;

import java.util.List;

import edu.ubb.cs.idde.server.model.User;

public interface UserService {
	List<User> getAllUsers() throws ServiceException;
}
