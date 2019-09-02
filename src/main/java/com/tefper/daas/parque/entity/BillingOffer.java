package com.tefper.daas.parque.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "billingoffer")
@Data
public class BillingOffer {

	@Id
	@Column(name = "id")
	private String	id;

	@Column(name = "name")
	private String	name;

	@Column(name = "pricetype")
	private String	priceType;

	@Column(name = "recurringchargeperiod")
	private String	recurringChargePeriod;

	@Column(name = "priceamount")
	private Double	amount;

	@Column(name = "priceunit")
	private String	unit;

	@Column(name = "assignedproductid")
	private String	assignedProductId;

	@Column(name = "indicadorplan")
	private String	indicadorPlan;

	@Column(name = "indicadormovistartotal")
	private String	indicadorMovistarTotal;

	@Column(name = "assignedmaincomponentkey")
	private String	assignedMainComponent;

	@Column(name = "idbillingoffer")
	private String	idbillingoffer;

}
