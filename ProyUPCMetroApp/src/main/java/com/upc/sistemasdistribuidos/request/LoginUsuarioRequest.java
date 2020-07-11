package com.upc.sistemasdistribuidos.request;

import com.upc.sistemasdistribuidos.bussines.UsuarioRest;

public class LoginUsuarioRequest {
	
	private UsuarioRest usuario;

	public UsuarioRest getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioRest usuario) {
		this.usuario = usuario;
	}
}
