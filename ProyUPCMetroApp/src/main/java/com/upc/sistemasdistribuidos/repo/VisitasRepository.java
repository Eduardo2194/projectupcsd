package com.upc.sistemasdistribuidos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.sistemasdistribuidos.model.Visita;

@Repository
public interface VisitasRepository extends JpaRepository<Visita, Integer>{

	public Visita findByFecvisita(String fecvisita);
	
}
