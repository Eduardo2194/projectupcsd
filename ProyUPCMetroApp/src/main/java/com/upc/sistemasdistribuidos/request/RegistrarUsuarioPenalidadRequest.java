package com.upc.sistemasdistribuidos.request;

import com.upc.sistemasdistribuidos.bussines.PenalidadRest;
import com.upc.sistemasdistribuidos.bussines.UsuarioRest;

public class RegistrarUsuarioPenalidadRequest {
	
	private UsuarioRest usuario;
	private PenalidadRest penalidad;
	public UsuarioRest getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioRest usuario) {
		this.usuario = usuario;
	}
	public PenalidadRest getPenalidad() {
		return penalidad;
	}
	public void setPenalidad(PenalidadRest penalidad) {
		this.penalidad = penalidad;
	}

}
