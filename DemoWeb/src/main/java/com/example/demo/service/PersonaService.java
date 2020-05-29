package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.repo.IPersonaRepo;

@Service
public class PersonaService {
	
	@Autowired
	private IPersonaRepo repo;
	
	
	public List<Persona> lisAll(){
		
		return repo.findAll();
	}

	public void save(Persona persona) {
		
		repo.save(persona);
	}
	
	
	public Persona get(Integer idPersona) {
		
		return repo.findById(idPersona).get();
	}
	
	public void delete(Integer idPersona) {
		
		 repo.deleteById(idPersona);
	}
	
	
}
