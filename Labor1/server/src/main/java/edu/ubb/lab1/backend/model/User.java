/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.lab1.backend.model;

public class User extends BaseEntity implements Comparable<User> {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String username;
	private String password;

	// Constructors
	public User() {
		this(null, null, null, null);
	}
	
	public User(String name, String username) {
		this(null, name, username, null);
	}
	
	public User(Long id, String name, String username) {
		this(id, name, username, null);
	}
	
	public User(String name, String username, String password) {
		this(null, name, username, password);
	}
	
	public User(Long id, String name, String username, String password) {
		super(id);
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	// Setters and getters
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	// toString
	@Override
	public String toString() { 
	    return "Name: " + name + ", Username: " + username + ", Password: " + password;
	}
	
	// compareTo
	@Override
	public int compareTo(User user) {
		if (name.equals(user.getName()) && username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			return 1;
		} else {
			return 0;
		}
	}
}
