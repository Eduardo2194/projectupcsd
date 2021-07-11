package com.upc.sistemasdistribuidos.response;

import java.util.List;

import com.upc.sistemasdistribuidos.bussines.IndicadorVisitaRest;
import com.upc.sistemasdistribuidos.type.base.ResponseBase;

public class GestionarListaVisitasResp extends ResponseBase{
	
	private List<IndicadorVisitaRest> indicador;

	public List<IndicadorVisitaRest> getIndicador() {
		return indicador;
	}

	public void setIndicador(List<IndicadorVisitaRest> indicador) {
		this.indicador = indicador;
	}

}
