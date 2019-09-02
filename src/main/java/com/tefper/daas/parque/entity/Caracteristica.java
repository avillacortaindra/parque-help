package com.tefper.daas.parque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "caracteristicas")
@IdClass(CaracteristicaIdentity.class)
@Data
public class Caracteristica {

	@Id
	@Column(name = "id")
	private String	id;

	@Id
	@Column(name = "name")
	private String	nombre;

	@Column(name = "value")
	private String	valor;

}
