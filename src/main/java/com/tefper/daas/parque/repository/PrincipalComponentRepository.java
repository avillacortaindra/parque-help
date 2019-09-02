package com.tefper.daas.parque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tefper.daas.parque.entity.PrincipalComponent;

@Repository
public interface PrincipalComponentRepository extends JpaRepository<PrincipalComponent, String> {

	public PrincipalComponent findById(String id);

	public List<PrincipalComponent> findBySuscriberId(String suscriber);

	public PrincipalComponent findBySuscriberIdAndProducType(String suscriber, String productType);
	
	@Query("select pc from PrincipalComponent pc where pc.suscriberId = :suscriberId and pc.producType <> :productType")
	public PrincipalComponent findBySuscriberIdLandLine(@Param("suscriberId")String suscriber, @Param("productType")String productType);

}
