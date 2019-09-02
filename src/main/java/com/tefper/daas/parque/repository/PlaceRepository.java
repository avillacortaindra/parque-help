package com.tefper.daas.parque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tefper.daas.parque.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, String> {

	public List<Place> findByBillingArrangement(String billingArrangement);

}
