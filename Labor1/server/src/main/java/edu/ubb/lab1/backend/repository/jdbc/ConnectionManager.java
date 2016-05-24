/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.lab1.backend.repository.jdbc;

import edu.ubb.lab1.backend.repository.RepositoryException;
import edu.ubb.lab1.backend.util.PropertyProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ConnectionManager {
	private static final int SIZE = Integer.parseInt(PropertyProvider.getProperty("dbConnectionPoolSize"));
	
	private static final Logger LOG = LoggerFactory.getLogger(ConnectionManager.class);
	
	private final List<Connection> pool;
	private static ConnectionManager instance;
	
	private ConnectionManager () throws RepositoryException {
		pool = new LinkedList<Connection> ();
		initializePool ();
	}
	
	public synchronized static ConnectionManager getInstance () throws RepositoryException {
		if (instance == null) {
			instance = new ConnectionManager ();
		}
		return instance;
	}
	
	public synchronized Connection getConnection () throws RepositoryException {
		Connection con = null;
		if (pool.size () > 0) {
			con = pool.get (0);
			pool.remove (0);
		}
		if (con == null) {
			LOG.info("No connections in pool.");
			throw new RepositoryException ("No connections in pool.");
		}
		return con;
	}
	
	public synchronized void returnConnection (final Connection con) {
		if (pool.size () < SIZE && con != null) {
			pool.add (con);
		}
	}
	
	private void initializePool () throws RepositoryException {
		try {
			Class.forName(PropertyProvider.getProperty("dbDriver"));
			
			String dbURL = PropertyProvider.getProperty("dbURL");
			String dbUser = PropertyProvider.getProperty("dbUser");
			String dbPassword = PropertyProvider.getProperty("dbPassword");
			
			for(int i = 0; i < SIZE; i++) {
				pool.add(DriverManager.getConnection(dbURL, dbUser, dbPassword));
			}
		} catch (ClassNotFoundException e) {
			LOG.error("ClassNotFoundException: " + e, e);
			throw new RepositoryException ("MySQL-JDBC connection driver not found.");
		} catch (SQLException e) {
			LOG.error("SQLException: " + e, e);
			throw new RepositoryException (e.getMessage());
		}
	}
}
