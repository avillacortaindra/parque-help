package com.tefper.daas.parque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tefper.daas.parque.entity.Caracteristica;


public interface CaracteristicaRepository extends JpaRepository<Caracteristica, String> {

	public List<Caracteristica> findById(String id);
}
