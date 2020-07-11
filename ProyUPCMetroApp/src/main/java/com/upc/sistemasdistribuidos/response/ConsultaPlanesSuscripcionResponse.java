package com.upc.sistemasdistribuidos.response;

import java.util.List;

import com.upc.sistemasdistribuidos.bussines.PlanesSuscripcionRest;
import com.upc.sistemasdistribuidos.type.base.ResponseBase;



public class ConsultaPlanesSuscripcionResponse extends ResponseBase {

    private List<PlanesSuscripcionRest> planes;

	public List<PlanesSuscripcionRest> getPlanes() {
		return planes;
	}
	public void setPlanes(List<PlanesSuscripcionRest> planes) {
		this.planes = planes;
    }
    
}