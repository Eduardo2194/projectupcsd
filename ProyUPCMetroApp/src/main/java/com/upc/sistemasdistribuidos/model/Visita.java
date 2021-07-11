package com.upc.sistemasdistribuidos.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Visita")
@EntityListeners(AuditingEntityListener.class)
public class Visita {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String fecvisita;
	private Integer cantvisita;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFecvisita() {
		return fecvisita;
	}
	public void setFecvisita(String fecvisita) {
		this.fecvisita = fecvisita;
	}
	public Integer getCantvisita() {
		return cantvisita;
	}
	public void setCantvisita(Integer cantvisita) {
		this.cantvisita = cantvisita;
	}

}
