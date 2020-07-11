package com.upc.sistemasdistribuidos.request;

import com.upc.sistemasdistribuidos.bussines.UsuarioRest;

public class RegistrarSuscripcionRequest {
	
    private UsuarioRest usuario;
 //   private PlanesSuscripcion plan;

	public UsuarioRest getUsuario() {
		return usuario;
	}
    public void setUsuario(UsuarioRest usuario) {
		this.usuario = usuario;
    }
//
//    public PlanesSuscripcion getPlan() {
//        return plan;
//    }
//    public void setPlan(PlanesSuscripcion plan) {
//        this.plan = plan;
//    }
//    
}