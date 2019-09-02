package com.tefper.daas.parque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tefper.daas.parque.entity.Component;

@Repository
public interface ComponentRepository extends JpaRepository<Component, String> {

	public List<Component> findByMaincomponentkey(String mainComponentKey);

	public List<Component> findByParentassignproductid(String íd);
}
