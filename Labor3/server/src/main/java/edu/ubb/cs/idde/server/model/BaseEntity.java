/*
 * Name: Tôkés Tibor 
 * ID: ttim1382
 * Group: 532
 */

package edu.ubb.cs.idde.server.model;

import java.io.Serializable;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity extends AbstractModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
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
