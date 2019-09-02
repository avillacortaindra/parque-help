package com.tefper.daas.parque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tefper.daas.parque.entity.BillingOffer;

@Repository
public interface BillingOfferRepository extends JpaRepository<BillingOffer, String> {

	public List<BillingOffer> findByAssignedProductId(String assignedProductId);

	public List<BillingOffer> findByAssignedMainComponentAndIndicadorPlan(String mainComponentKey, String indicadorPlan);

}
