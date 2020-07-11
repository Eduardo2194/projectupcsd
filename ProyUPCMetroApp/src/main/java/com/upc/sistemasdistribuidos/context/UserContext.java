package com.upc.sistemasdistribuidos.context;

import com.upc.sistemasdistribuidos.bussines.UsuarioRest;
import com.upc.sistemasdistribuidos.request.GestionarProblemaRequest;
import com.upc.sistemasdistribuidos.request.GestionarUsuarioRequest;
import com.upc.sistemasdistribuidos.request.LoginUsuarioRequest;
import com.upc.sistemasdistribuidos.response.ConsultaUsuarioPenalidadResponse;
import com.upc.sistemasdistribuidos.response.GestionarProblemaResponse;
import com.upc.sistemasdistribuidos.response.GestionarUsuarioResponse;
import com.upc.sistemasdistribuidos.response.ListarProblemasResponse;
import com.upc.sistemasdistribuidos.response.LoginUsuarioResponse;

public class UserContext extends Context{
	
	private UsuarioRest userRestEntity;
	
	private LoginUsuarioRequest loginRequest;
	private LoginUsuarioResponse loginResponse;
	
	private GestionarUsuarioRequest gestionarRequest;
	private GestionarUsuarioResponse gestionarResponse;
	
	private String dni;
	private ConsultaUsuarioPenalidadResponse consultaPenalidadResponse;
	
	private GestionarProblemaRequest registrarProblemaRequest;
	private GestionarProblemaResponse registrarProblemaResponse;
	
	private ListarProblemasResponse listarProblemasResponse;
	
	public UsuarioRest getUserRestEntity() {
		return userRestEntity;
	}
	public void setUserRestEntity(UsuarioRest userRestEntity) {
		this.userRestEntity = userRestEntity;
	}
	public LoginUsuarioRequest getLoginRequest() {
		return loginRequest;
	}
	public void setLoginRequest(LoginUsuarioRequest loginRequest) {
		this.loginRequest = loginRequest;
	}
	public LoginUsuarioResponse getLoginResponse() {
		return loginResponse;
	}
	public void setLoginResponse(LoginUsuarioResponse loginResponse) {
		this.loginResponse = loginResponse;
	}
	public GestionarUsuarioRequest getGestionarRequest() {
		return gestionarRequest;
	}
	public void setGestionarRequest(GestionarUsuarioRequest gestionarRequest) {
		this.gestionarRequest = gestionarRequest;
	}
	public GestionarUsuarioResponse getGestionarResponse() {
		return gestionarResponse;
	}
	public void setGestionarResponse(GestionarUsuarioResponse gestionarResponse) {
		this.gestionarResponse = gestionarResponse;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public ConsultaUsuarioPenalidadResponse getConsultaPenalidadResponse() {
		return consultaPenalidadResponse;
	}
	public void setConsultaPenalidadResponse(ConsultaUsuarioPenalidadResponse consultaPenalidadResponse) {
		this.consultaPenalidadResponse = consultaPenalidadResponse;
	}
	public GestionarProblemaRequest getRegistrarProblemaRequest() {
		return registrarProblemaRequest;
	}
	public void setRegistrarProblemaRequest(GestionarProblemaRequest registrarProblemaRequest) {
		this.registrarProblemaRequest = registrarProblemaRequest;
	}
	public GestionarProblemaResponse getRegistrarProblemaResponse() {
		return registrarProblemaResponse;
	}
	public void setRegistrarProblemaResponse(GestionarProblemaResponse registrarProblemaResponse) {
		this.registrarProblemaResponse = registrarProblemaResponse;
	}
	public ListarProblemasResponse getListarProblemasResponse() {
		return listarProblemasResponse;
	}
	public void setListarProblemasResponse(ListarProblemasResponse listarProblemasResponse) {
		this.listarProblemasResponse = listarProblemasResponse;
	}
	
	
}
