package com.tefper.daas.parque.entity;

import java.io.Serializable;

public class BillingOfferPropertieListIdentity implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private String				billingOfferId;
	private String				propertiesName;

	public BillingOfferPropertieListIdentity() {
		super();
	}

	public BillingOfferPropertieListIdentity(String billingOfferId, String propertiesName) {
		super();
		this.billingOfferId = billingOfferId;
		this.propertiesName = propertiesName;
	}

	public String getBillingOfferId() {
		return billingOfferId;
	}

	public void setBillingOfferId(String billingOfferId) {
		this.billingOfferId = billingOfferId;
	}

	public String getPropertiesName() {
		return propertiesName;
	}

	public void setPropertiesName(String propertiesName) {
		this.propertiesName = propertiesName;
	}

}
