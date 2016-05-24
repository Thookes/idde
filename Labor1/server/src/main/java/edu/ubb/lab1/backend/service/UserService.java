/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.lab1.backend.service;

import java.util.List;

import edu.ubb.lab1.backend.model.User;

public interface UserService {
	List<User> getAllUsers() throws ServiceException;
}
