package com.tefper.daas.parque.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "componentes")
@Data
public class Component {

	@Id
	@Column(name = "id")
	private String	id;

	@Column(name = "description")
	private String	description;

	@Column(name = "name")
	private String	name;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "startdate")
	private Date	startdate;

	@Column(name = "subscriberid")
	private String	suscriber;

	@Column(name = "maincomponentkey")
	private String	maincomponentkey;

	@Column(name = "parentassignproductid")
	private String	parentassignproductid;

	@Column(name = "producttype")
	private String	producttype;

}
