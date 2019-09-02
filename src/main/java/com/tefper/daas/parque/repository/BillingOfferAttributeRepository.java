package com.tefper.daas.parque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tefper.daas.parque.entity.BillingOfferAttribute;

@Repository
public interface BillingOfferAttributeRepository extends JpaRepository<BillingOfferAttribute, String> {

	public List<BillingOfferAttribute> findByBillingOfferID(String billingOfferId);

}
