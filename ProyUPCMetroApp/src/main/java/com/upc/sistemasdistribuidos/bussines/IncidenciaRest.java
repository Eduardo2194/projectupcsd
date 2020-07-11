package com.upc.sistemasdistribuidos.bussines;

public class IncidenciaRest {

	private Integer id;
	private String idUsuario;
	private String descripcion;
	private String tipo;
	private String estado;

	private UsuarioRest datosPasajero;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public UsuarioRest getDatosPasajero() {
		return datosPasajero;
	}

	public void setDatosPasajero(UsuarioRest datosPasajero) {
		this.datosPasajero = datosPasajero;
	}
	
	
}
