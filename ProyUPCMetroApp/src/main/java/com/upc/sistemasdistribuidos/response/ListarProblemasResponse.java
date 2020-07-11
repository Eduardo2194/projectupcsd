package com.upc.sistemasdistribuidos.response;

import java.util.List;

import com.upc.sistemasdistribuidos.bussines.ListProblemaRest;
import com.upc.sistemasdistribuidos.type.base.ResponseBase;


public class ListarProblemasResponse extends ResponseBase {

	private List<ListProblemaRest> listaProblema;

	public List<ListProblemaRest> getListaProblema() {
		return listaProblema;
	}

	public void setListaProblema(List<ListProblemaRest> listaProblema) {
		this.listaProblema = listaProblema;
	}
}
