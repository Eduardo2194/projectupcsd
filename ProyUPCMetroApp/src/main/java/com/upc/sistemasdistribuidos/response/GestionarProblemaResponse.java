package com.upc.sistemasdistribuidos.response;

import com.upc.sistemasdistribuidos.bussines.ProblemaRest;
import com.upc.sistemasdistribuidos.type.base.ResponseBase;

public class GestionarProblemaResponse extends ResponseBase {

	private ProblemaRest problema;

	public ProblemaRest getProblema() {
		return problema;
	}

	public void setProblema(ProblemaRest problema) {
		this.problema = problema;
	}
}
