package com.tefper.daas.parque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tefper.daas.parque.entity.AppsIlimitada;

public interface AppsIlimitadaRepository extends JpaRepository<AppsIlimitada, String> {

	public List<AppsIlimitada> findById(String id);
}
