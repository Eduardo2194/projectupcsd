package com.upc.sistemasdistribuidos.bussines;


public class MovimientoRest {
	
	private Integer id;
	private String idUsuario;
	private String tipoMov;
	private String idTipoTransp;
	private String monto;
	private Double saldo;
	
	
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
	public String getTipoMov() {
		return tipoMov;
	}
	public void setTipoMov(String tipoMov) {
		this.tipoMov = tipoMov;
	}
	public String getIdTipoTransp() {
		return idTipoTransp;
	}
	public void setIdTipoTransp(String idTipoTransp) {
		this.idTipoTransp = idTipoTransp;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
