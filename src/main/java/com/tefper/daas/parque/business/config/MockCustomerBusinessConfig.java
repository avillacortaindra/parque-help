package com.tefper.daas.parque.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tefper.daas.parque.business.CustomerBusiness;
import com.tefper.daas.parque.business.impl.CustomerBusinessImplTest;

@Configuration
@Profile("local")
public class MockCustomerBusinessConfig {

	@Bean
	public CustomerBusiness customerBusiness() {
		return new CustomerBusinessImplTest();
	}
}
