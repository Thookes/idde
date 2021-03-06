/*
 * Name: T�k�s Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.interfce.model;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	public BaseEntity() {
		this(null);
	}

	public BaseEntity(final Long id) {
		super ();
		this.id = id;
	}

	public Long getID() {
		return id;
	}
	
	public void setID(final Long id) {
		this.id = id;
	}
}

