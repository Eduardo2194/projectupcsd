package com.upc.sistemasdistribuidos.response;

import com.upc.sistemasdistribuidos.bussines.UsuarioRest;
import com.upc.sistemasdistribuidos.type.base.ResponseBase;

public class GestionarSaldoResponse extends ResponseBase {

	private UsuarioRest usuario;

	public UsuarioRest getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioRest usuario) {
		this.usuario = usuario;
	}

}
