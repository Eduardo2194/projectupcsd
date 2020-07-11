package com.upc.sistemasdistribuidos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Detalle_movimiento")
@EntityListeners(AuditingEntityListener.class)
public class Movimiento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String idUsuario;
	private String tipoMov;
	private String idTipoTransp;
	private String monto;
	private Date fechaRegistro;
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
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
