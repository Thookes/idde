/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.lab1.backend.repository;

public class RepositoryException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public RepositoryException() {
		super ();
	}
	
	public RepositoryException(final String message) {
		super (message);
	}
	
	public RepositoryException(final String message, final Throwable cause) {
		super (message, cause);
	}
}
