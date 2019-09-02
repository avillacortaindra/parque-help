package com.tefper.daas.parque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tefper.daas.parque.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

	public Customer findById(String id);

	public List<Customer> findByTipodocumentoAndNumerodocumento (String tipoDocumento, String numeroDocumento);
}
