/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.lab1.backend.repository;

import java.util.List;

import edu.ubb.lab1.backend.model.User;

public interface UserDAO {
		List<User> getAllUsers() throws RepositoryException;
}
