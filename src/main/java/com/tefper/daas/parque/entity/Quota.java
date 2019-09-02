package com.tefper.daas.parque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "quotas")
@IdClass(QuotaIdentity.class)
@Data
public class Quota {

	@Column(name = "cantidad")
	private Double	cantidad;

	@Column(name = "unidad")
	private String	unidad;

	@Column(name = "banda")
	private String	banda;

	@Column(name = "origen")
	private String	origen;

	@Column(name = "destino")
	private String	destino;

	@Column(name = "destino_roaming")
	private String	destinoroaming;

	@Id
	@Column(name = "tipo_quota")
	private String	tipoquota;

	@Id
	@Column(name = "assignedproducto")
	private String	assignedproductid;

}
