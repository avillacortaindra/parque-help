package com.tefper.daas.parque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tefper.daas.parque.entity.Quota;

@Repository
public interface QuotaRepository extends JpaRepository<Quota, String> {

	public List<Quota> findByAssignedproductid(String assignedproductid);
}
