package com.upc.sistemasdistribuidos.request;

import java.io.Serializable;

import com.upc.sistemasdistribuidos.bussines.IncidenciaRest;

public class GestionarProblemaRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private IncidenciaRest problema;

	public IncidenciaRest getProblema() {
		return problema;
	}

	public void setProblema(IncidenciaRest problema) {
		this.problema = problema;
	}
}
