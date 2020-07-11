package com.upc.sistemasdistribuidos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.sistemasdistribuidos.model.Movimiento;
import com.upc.sistemasdistribuidos.repo.MovimientoRepository;

@Service
public class SaldoDAO {
	
	@Autowired
	MovimientoRepository movimientoRepository;

	
	/*registrar un movimiento*/
	public Movimiento registrarUsuario(Movimiento movimiento) {
		return movimientoRepository.save(movimiento);
	}
	
	
	/*buscar movimientos*/
	public List<Movimiento> findFirstByidUsuario (String dni) {
		return movimientoRepository.findFirstByidUsuario(dni);
	}
		
	
}
