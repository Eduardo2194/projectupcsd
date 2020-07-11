package com.upc.sistemasdistribuidos.request;

import java.io.Serializable;

import com.upc.sistemasdistribuidos.bussines.UsuarioRest;

public class GestionarUsuarioRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private UsuarioRest usuario;

	public UsuarioRest getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioRest usuario) {
		this.usuario = usuario;
	}
}
