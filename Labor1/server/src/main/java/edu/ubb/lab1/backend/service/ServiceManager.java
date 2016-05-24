/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.lab1.backend.service;

import edu.ubb.lab1.backend.service.impl.UserServiceImpl;

public final class ServiceManager {
	
	public static UserService getUserService() {
		return new UserServiceImpl();
	}
}
