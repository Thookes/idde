/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.lab1.backend.model;

import java.io.Serializable;

public class BaseEntity extends AbstractModel implements Serializable {
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
