package com.tefper.daas.parque.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tefper.daas.parque.business.ProductBusiness;
import com.tefper.daas.parque.business.impl.ProductBusinessImplTest;

@Configuration
@Profile("local")
public class MockProductBusinessConfig {

	@Bean
	public ProductBusiness productBusiness() {
		return new ProductBusinessImplTest();
	}
}
