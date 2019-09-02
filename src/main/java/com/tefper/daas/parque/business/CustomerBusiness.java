package com.tefper.daas.parque.business;

import java.util.List;

import com.tefper.daas.parque.model.ProductInstanceType;

public interface CustomerBusiness {

	public List<ProductInstanceType> getCustomerProductById (String customerId);
	
	public List<ProductInstanceType> getCustomerProductByTypeAndDocument(String documentType, String documentNumber);
}
