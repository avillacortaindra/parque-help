package com.tefper.daas.parque.business.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tefper.daas.parque.business.CustomerBusiness;
import com.tefper.daas.parque.business.impl.CustomerBusinessImpl;
import com.tefper.daas.parque.util.Constant;
import com.tefper.daas.parque.util.SubscriberState;

@Configuration
@Profile("!local")
public class CustomerBusinessConfig {

	@Bean
	public CustomerBusiness customerBusiness() {
		return new CustomerBusinessImpl();
	}

	@Bean(name = "subscriberStateActive")
	public Set<String> subscriberStateActive() {
		Set<String> subscriberActives = new HashSet<>();
		subscriberActives.add(SubscriberState.RESERVED.toString());
		subscriberActives.add(SubscriberState.COLLECTION_WAS_SUSPENSION.toString());
		subscriberActives.add(SubscriberState.PRE_ACTIVATED.toString());
		subscriberActives.add(SubscriberState.COLLECTION_WAS_ACTIVE.toString());
		subscriberActives.add(SubscriberState.ACTIVE.toString());
		subscriberActives.add(SubscriberState.SUSPENDED.toString());
		return subscriberActives;
	}

	@Bean(name = "dataSharing")
	public Set<String> dataSharing() {
		Set<String> dataSharing = new HashSet<>();
		dataSharing.add(Constant.SHARINGDATACONSUMER_VALUE);
		dataSharing.add(Constant.SHARINGDATAOWNER_VALUE);
		return dataSharing;
	}
}
