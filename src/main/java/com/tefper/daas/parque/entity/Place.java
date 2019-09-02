package com.tefper.daas.parque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "place")
@Data
public class Place {

	@Id
	@Column(name = "id")
	private String	id;

	@Column(name = "name")
	private String	name;

	@Column(name = "description")
	private String	description;

	@Column(name = "billingarrangement")
	private String	billingArrangement;
}
