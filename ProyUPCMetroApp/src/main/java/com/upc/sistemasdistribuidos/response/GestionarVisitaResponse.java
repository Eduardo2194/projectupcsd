package com.upc.sistemasdistribuidos.response;

import com.upc.sistemasdistribuidos.bussines.IndicadorVisitaRest;
import com.upc.sistemasdistribuidos.type.base.ResponseBase;

public class GestionarVisitaResponse extends ResponseBase {
	
	private IndicadorVisitaRest indicador;

	public IndicadorVisitaRest getIndicador() {
		return indicador;
	}

	public void setIndicador(IndicadorVisitaRest indicador) {
		this.indicador = indicador;
	}

}
