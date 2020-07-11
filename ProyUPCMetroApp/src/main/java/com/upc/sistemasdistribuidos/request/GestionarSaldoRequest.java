package com.upc.sistemasdistribuidos.request;

import java.io.Serializable;

import com.upc.sistemasdistribuidos.bussines.IncidenciaRest;
import com.upc.sistemasdistribuidos.bussines.MovimientoRest;
import com.upc.sistemasdistribuidos.bussines.UsuarioRest;

public class GestionarSaldoRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private UsuarioRest usuario;
	private MovimientoRest movimiento;

	public UsuarioRest getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioRest usuario) {
		this.usuario = usuario;
	}

	public MovimientoRest getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(MovimientoRest movimiento) {
		this.movimiento = movimiento;
	}
	
	
	
}
