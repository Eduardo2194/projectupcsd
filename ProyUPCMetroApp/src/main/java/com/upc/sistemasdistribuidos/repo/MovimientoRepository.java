package com.upc.sistemasdistribuidos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upc.sistemasdistribuidos.model.Movimiento;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer>{

	public List<Movimiento> findFirstByidUsuario(String idUsuario);

	
}
