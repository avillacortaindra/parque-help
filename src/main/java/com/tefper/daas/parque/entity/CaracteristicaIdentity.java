package com.tefper.daas.parque.entity;

import java.io.Serializable;

public class CaracteristicaIdentity implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private String				id;

	private String				nombre;

	public CaracteristicaIdentity() {}

	public CaracteristicaIdentity(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
