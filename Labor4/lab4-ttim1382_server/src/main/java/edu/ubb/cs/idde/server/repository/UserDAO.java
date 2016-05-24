/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.repository;

import java.util.List;

import edu.ubb.cs.idde.interfce.model.UserEntity;

public interface UserDAO {
		List<UserEntity> getAllUsers() throws RepositoryException;
}
