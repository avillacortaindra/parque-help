package com.tefper.daas.parque.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "principalcomponent")
@Data
public class PrincipalComponent {

	@Id
	@Column(name = "id")
	private String	id;

	@Column(name = "subscriberid")
	private String	suscriberId;

	@Column(name = "description")
	private String	description;

	@Column(name = "name")
	private String	name;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "orderdate")
	private Date	orderdate;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "startdate")
	private Date	startdate;

	@Column(name = "status")
	private String	status;

	@Column(name = "descriptionproductoffering")
	private String	descriptionproductoffering;

	@Column(name = "maincomponentkey")
	private String	maincomponentkey;

	@Column(name = "producttype")
	private String	producType;

	@Column(name = "isbundle")
	private String	isbundle;

	@Column(name = "terminationdate")
	private String	terminationdate;
}
