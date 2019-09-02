package com.tefper.daas.parque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "billing_offer_attributes_list")
@Data
public class BillingOfferAttribute {

	@Column(name = "billing_offer_id")
	private String	billingOfferID;

	@Id
	@Column(name = "attribute_id")
	private String	attributeId;

	@Column(name = "attribute_default_value")
	private String	attributeDefaultValue;

	@Column(name = "name_list_type_name_local")
	private String	nameListTypeNameLocal;

}
