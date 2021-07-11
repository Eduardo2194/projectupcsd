package com.upc.sistemasdistribuidos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.upc.sistemasdistribuidos.model.Visita;
import com.upc.sistemasdistribuidos.repo.VisitasRepository;

@Service
public class VisitaDAO {
	
	@Autowired
	VisitasRepository visitasRepository;
	
	/*registrar una visita*/
	public Visita registrarVisita(Visita usuario) {
		return visitasRepository.save(usuario);
	}
	
	/*buscar un visita por fecha*/
	public Visita findByFecvisita(String fecvisita) {
		return visitasRepository.findByFecvisita(fecvisita);
	}
	
	/*listar visitas*/
	public List<Visita> findVisitasAll() {
		return visitasRepository.findAll();
	}

}
