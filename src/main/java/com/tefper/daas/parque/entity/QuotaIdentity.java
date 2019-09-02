package com.tefper.daas.parque.entity;

import java.io.Serializable;

public class QuotaIdentity implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private String				assignedproductid;

	private String				tipoquota;

	public QuotaIdentity() {}

	public QuotaIdentity(String assignedproductid, String tipoquota) {
		super();
		this.assignedproductid = assignedproductid;
		this.tipoquota = tipoquota;
	}

	public String getAssignedproductid() {
		return assignedproductid;
	}

	public void setAssignedproductid(String assignedproductid) {
		this.assignedproductid = assignedproductid;
	}

	public String getTipoquota() {
		return tipoquota;
	}

	public void setTipoquota(String tipoquota) {
		this.tipoquota = tipoquota;
	}

}
