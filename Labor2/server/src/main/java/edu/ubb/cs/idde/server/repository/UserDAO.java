/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.repository;

import java.util.List;

import edu.ubb.cs.idde.server.model.User;

public interface UserDAO {
		List<User> getAllUsers() throws RepositoryException;
}
