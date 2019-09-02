package com.tefper.daas.parque.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tefper.daas.parque.business.ProductBusiness;
import com.tefper.daas.parque.business.impl.ProductBusinessImpl;

@Configuration
@Profile("!local")
public class ProductBusinessConfig {

	@Bean
	public ProductBusiness productBusiness() {
		return new ProductBusinessImpl();
	}
}
