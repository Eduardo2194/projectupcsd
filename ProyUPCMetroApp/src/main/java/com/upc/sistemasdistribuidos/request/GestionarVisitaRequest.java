package com.upc.sistemasdistribuidos.request;

import java.io.Serializable;

import com.upc.sistemasdistribuidos.bussines.IndicadorVisitaRest;


public class GestionarVisitaRequest  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private IndicadorVisitaRest visitas;

	public IndicadorVisitaRest getVisitas() {
		return visitas;
	}

	public void setVisitas(IndicadorVisitaRest visitas) {
		this.visitas = visitas;
	}

}
