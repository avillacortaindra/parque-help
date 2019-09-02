
package com.tefper.daas.parque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "subscriber")
@Data
public class Suscriber {

	@Id
	@Column(name = "subscriberid")
	private String	suscriberid;

	@Column(name = "fechaalta")
	private String	fechaalta;

	@Column(name = "msisdn")
	private String	msisdn;

	@Column(name = "category")
	private String	category;

	@Column(name = "id")
	private String	id;

	@Column(name = "idbilling")
	private String	idbillingaccount;

	@Column(name = "namebilling")
	private String	nameaccount;

	@Column(name = "billingarrangement")
	private String	billingArrangement;

	@Column(name = "ciclofacturacion")
	private String	ciclofacturacion;

	@Column(name = "estado")
	private String	estado;

}
