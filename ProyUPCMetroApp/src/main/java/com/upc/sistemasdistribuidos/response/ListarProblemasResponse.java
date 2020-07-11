package com.upc.sistemasdistribuidos.response;

import java.util.List;

import com.upc.sistemasdistribuidos.bussines.ListIncidenciaRest;
import com.upc.sistemasdistribuidos.type.base.ResponseBase;


public class ListarProblemasResponse extends ResponseBase {

	private List<ListIncidenciaRest> listaProblema;

	public List<ListIncidenciaRest> getListaProblema() {
		return listaProblema;
	}

	public void setListaProblema(List<ListIncidenciaRest> listaProblema) {
		this.listaProblema = listaProblema;
	}
}
