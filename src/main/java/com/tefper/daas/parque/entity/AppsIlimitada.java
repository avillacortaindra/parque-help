package com.tefper.daas.parque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "APPILIMITADA")
@IdClass(AppsIlimitadaIdentity.class)
@Data
public class AppsIlimitada {

	@Id
	@Column(name = "ID")
	private String	id;

	@Id
	@Column(name = "NAME")
	private String	name;

}
