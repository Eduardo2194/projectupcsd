package com.upc.sistemasdistribuidos.service;

public interface UserProcessService {
	
	public void login();
	
	public void registrar();
	
	public void actualizar();

	public void recargarSaldo();
	
	public void eliminar();
	
//	public void consultaPenalidad();
	
	public void recuperarContrasena();

	public void registrarVisita();

	public void listarVisitas();
}
