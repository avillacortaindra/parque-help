package com.tefper.daas.parque.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tefper.daas.parque.entity.Suscriber;

@Repository
public interface SuscriberRepository extends JpaRepository<Suscriber, String> {

	@Query("select s from Suscriber s where s.msisdn = :msisdn and s.estado in :state")
	public Suscriber findByMsisdnAndEstado(@Param("msisdn") String msisdn, @Param("state") Set<String> state);

	public List<Suscriber> findById(String id);

	public Suscriber findBySuscriberid(String suscriberId);

}
