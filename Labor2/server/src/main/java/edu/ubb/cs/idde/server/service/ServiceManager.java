/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.service;

import edu.ubb.cs.idde.server.service.impl.UserServiceImpl;

public final class ServiceManager {
	
	public static UserService getUserService() {
		return new UserServiceImpl();
	}
}
