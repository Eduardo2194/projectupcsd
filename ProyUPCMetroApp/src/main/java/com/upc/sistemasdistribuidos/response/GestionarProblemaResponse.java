package com.upc.sistemasdistribuidos.response;

import com.upc.sistemasdistribuidos.bussines.IncidenciaRest;
import com.upc.sistemasdistribuidos.type.base.ResponseBase;

public class GestionarProblemaResponse extends ResponseBase {

	private IncidenciaRest problema;

	public IncidenciaRest getProblema() {
		return problema;
	}

	public void setProblema(IncidenciaRest problema) {
		this.problema = problema;
	}
}
