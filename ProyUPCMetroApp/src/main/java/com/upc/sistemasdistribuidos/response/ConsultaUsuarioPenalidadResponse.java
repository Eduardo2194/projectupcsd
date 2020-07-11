package com.upc.sistemasdistribuidos.response;

import com.upc.sistemasdistribuidos.bussines.PenalidadRest;
import com.upc.sistemasdistribuidos.bussines.UsuarioRest;
import com.upc.sistemasdistribuidos.type.base.ResponseBase;

public class ConsultaUsuarioPenalidadResponse extends ResponseBase {

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