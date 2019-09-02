package com.tefper.daas.parque.business;

import java.util.List;

import com.tefper.daas.parque.model.ProductInstanceType;

public interface ProductBusiness {

	public List<ProductInstanceType> getProductById(String productId);
	
	public List<ProductInstanceType> getProductByPublicIdAndProductType(String publicId, String productType);
}
