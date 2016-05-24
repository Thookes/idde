/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.service;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ServiceException() {
		super ();
	}
	
	public ServiceException(final String message) {
		super (message);
	}
	
	public ServiceException(final String message, final Throwable cause) {
		super (message, cause);
	}
}

