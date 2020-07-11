package com.upc.sistemasdistribuidos.request;

import java.io.Serializable;

import com.upc.sistemasdistribuidos.bussines.ProblemaRest;

public class GestionarProblemaRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ProblemaRest problema;

	public ProblemaRest getProblema() {
		return problema;
	}

	public void setProblema(ProblemaRest problema) {
		this.problema = problema;
	}
}
