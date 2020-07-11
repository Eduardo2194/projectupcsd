package com.upc.sistemasdistribuidos.response;

import com.upc.sistemasdistribuidos.bussines.PlanesSuscripcionRest;
import com.upc.sistemasdistribuidos.bussines.SuscripcionRest;
import com.upc.sistemasdistribuidos.bussines.UsuarioRest;
import com.upc.sistemasdistribuidos.type.base.ResponseBase;

public class RegistrarSuscripcionResponse extends ResponseBase {

    private UsuarioRest usuario;
    private PlanesSuscripcionRest plan; 
    private SuscripcionRest suscripcion;

	public UsuarioRest getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioRest usuario) {
		this.usuario = usuario;
	}
	public PlanesSuscripcionRest getPlan() {
		return plan;
	}
	public void setPlan(PlanesSuscripcionRest plan) {
		this.plan = plan;
	}
	public SuscripcionRest getSuscripcion() {
		return suscripcion;
	}
	public void setSuscripcion(SuscripcionRest suscripcion) {
		this.suscripcion = suscripcion;
	}
	
}