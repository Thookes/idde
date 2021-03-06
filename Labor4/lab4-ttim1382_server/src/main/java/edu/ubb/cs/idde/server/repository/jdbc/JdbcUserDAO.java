/*
 * Name: T�k�s Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.repository.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.cs.idde.interfce.model.UserEntity;
import edu.ubb.cs.idde.server.repository.RepositoryException;
import edu.ubb.cs.idde.server.repository.UserDAO;

public class JdbcUserDAO implements UserDAO {
	private final ConnectionManager cm;
	
	private static final Logger LOG = LoggerFactory.getLogger(JdbcUserDAO.class);
	
	public JdbcUserDAO() throws RepositoryException {
		cm = ConnectionManager.getInstance();
	}
	
	@Override
	public List<UserEntity> getAllUsers() throws RepositoryException {
		List<UserEntity> result = new LinkedList<UserEntity>();
		Connection con = null;
		try {
			con = cm.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ID, NAME, USERNAME FROM Users");
			while (rs.next()) {
				result.add(new UserEntity(rs.getLong(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			LOG.error("SQLException: " + e, e);
			throw new RepositoryException (e.getMessage());
		} finally {
			cm.returnConnection(con);
		}
		
		return result;
	}
}
