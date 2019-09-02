package com.tefper.daas.parque.business.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tefper.daas.parque.business.ProductBusiness;
import com.tefper.daas.parque.model.ProductInstanceType;

public class ProductBusinessImplTest implements ProductBusiness {

	@Autowired
	ResourceLoader resourceLoader;

	@Override
	public List<ProductInstanceType> getProductById(String productId) {
		return this.getMockResponse();
	}

	@Override
	public List<ProductInstanceType> getProductByPublicIdAndProductType(String publicId, String productType) {
		return this.getMockResponse();
	}

	@SuppressWarnings("unchecked")
	private List<ProductInstanceType> getMockResponse() {
		List<ProductInstanceType> pit = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			Resource resource = resourceLoader.getResource("classpath:response_test.json");
			pit = (List<ProductInstanceType>) mapper.readValue(resource.getFile(), List.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pit;
	}
}
