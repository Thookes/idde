/*
 * Name: T�k�s Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.interfce.model;

import edu.ubb.cs.idde.interfce.model.User;

public class UserEntity extends BaseEntity implements User, Comparable<UserEntity> {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String username;

	// Constructors
	public UserEntity() {
		this(null, null, null);
	}
	
	public UserEntity(String name, String username) {
		this(null, name, username);
	}
	
	public UserEntity(Long id, String name, String username) {
		super(id);
		this.name = name;
		this.username = username;
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
	
	// toString
	@Override
	public String toString() { 
	    return "Name: " + name + ", Username: " + username;
	}
	
	// compareTo
	@Override
	public int compareTo(UserEntity user) {
		if (name.equals(user.getName()) && username.equals(user.getUsername())) {
			return 1;
		} else {
			return 0;
		}
	}
}

