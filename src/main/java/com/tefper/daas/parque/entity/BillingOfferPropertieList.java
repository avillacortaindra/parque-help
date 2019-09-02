package com.tefper.daas.parque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "BILLING_OFFER_PROPERTIES_LIST")
@IdClass(BillingOfferPropertieListIdentity.class)
@Data
public class BillingOfferPropertieList {

	@Id
	@Column(name = "BILLING_OFFER_ID")
	private String	billingOfferId;

	@Id
	@Column(name = "PROPERTIES_NAME")
	private String	propertiesName;

	@Column(name = "PROPERTIES_VALUE")
	private String	propertiesValue;

}
