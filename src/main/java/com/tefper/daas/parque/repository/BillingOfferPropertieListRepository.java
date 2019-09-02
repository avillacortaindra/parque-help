package com.tefper.daas.parque.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tefper.daas.parque.entity.BillingOfferPropertieList;

public interface BillingOfferPropertieListRepository extends JpaRepository<BillingOfferPropertieList, String> {

	@Query("select bopl from BillingOfferPropertieList bopl where bopl.billingOfferId = :billingOfferId and bopl.propertiesName in :propertiesName")
	public List<BillingOfferPropertieList> findByBillingOfferIdAndPropertiesName(@Param("billingOfferId")String billingOfferId, @Param("propertiesName")Set<String> propertiesName);
}
