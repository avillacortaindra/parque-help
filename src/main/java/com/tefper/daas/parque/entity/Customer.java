package com.tefper.daas.parque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String	id;

	@Column(name = "name")
	private String	name;

	@Column(name = "tipodocumento")
	private String	tipodocumento;

	@Column(name = "numerodocumento")
	private String	numerodocumento;

	@Column(name = "ciclodefacturacion")
	private String	ciclodefacturacion;

}
