package com.upc.sistemasdistribuidos.controler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.upc.sistemasdistribuidos.Utils.Utils;
import com.upc.sistemasdistribuidos.constantes.ApplicationConstants;
import com.upc.sistemasdistribuidos.context.ContextHolder;
import com.upc.sistemasdistribuidos.context.UserContext;
import com.upc.sistemasdistribuidos.exceptions.BackEndException;
import com.upc.sistemasdistribuidos.request.GestionarSaldoRequest;
import com.upc.sistemasdistribuidos.request.GestionarUsuarioRequest;
import com.upc.sistemasdistribuidos.request.LoginUsuarioRequest;
import com.upc.sistemasdistribuidos.response.GestionarSaldoResponse;
import com.upc.sistemasdistribuidos.response.GestionarUsuarioResponse;
import com.upc.sistemasdistribuidos.response.LoginUsuarioResponse;
import com.upc.sistemasdistribuidos.service.UserProcessService;

@RestController
@RequestMapping(ApplicationConstants.APPLICATION_CONTEXT)
public class UsuarioController {
	
	private final static String BASE_PATH = "/usuario";
	
	private static final Logger LOGGER = LogManager.getLogger(UsuarioController.class);
	
	@Autowired 
	private UserProcessService processService;
	
	
	@RequestMapping(path = BASE_PATH + "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<LoginUsuarioResponse> processLoginUsuario(@RequestBody LoginUsuarioRequest request) {
		final String methodName = "processLoginUsuario";
		LOGGER.traceEntry(methodName);
		LoginUsuarioResponse response = new LoginUsuarioResponse();
		ResponseEntity<LoginUsuarioResponse> httpResponse = null;
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR; 
		try {
			UserContext context = ContextHolder.get(UserContext.class);
			context.setLoginRequest(request);
			context.setLoginResponse(response);

			processService.login();

			response = context.getLoginResponse();
			httpStatus = HttpStatus.OK;
		} catch (BackEndException e) {
			response.setStatus(Utils.buildErrorValidationStatus(e));
		} catch (Exception e) {
			response.setStatus(Utils.buildErrorStatus(e));
		} 
		httpResponse = new ResponseEntity<LoginUsuarioResponse>(response, httpStatus);
		LOGGER.traceExit();
		return httpResponse;
	}
	
	
	@RequestMapping(path = BASE_PATH, method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<GestionarUsuarioResponse> processRegistrarUsuario(@RequestBody GestionarUsuarioRequest request) {
		final String methodName = "processRegistrarUsuario";
		LOGGER.traceEntry(methodName);
		GestionarUsuarioResponse response = new GestionarUsuarioResponse();
		ResponseEntity<GestionarUsuarioResponse> httpResponse = null;
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR; 
		try {
			UserContext context = ContextHolder.get(UserContext.class);
			context.setGestionarRequest(request);
			context.setGestionarResponse(response);

			processService.registrar();

			response = context.getGestionarResponse();
			httpStatus = HttpStatus.OK; 
		} catch (BackEndException e) {
			response.setStatus(Utils.buildErrorValidationStatus(e));
		} catch (Exception e) {
			response.setStatus(Utils.buildErrorStatus(e));
		} 
		httpResponse = new ResponseEntity<GestionarUsuarioResponse>(response, httpStatus);
		LOGGER.traceExit();
		return httpResponse;
	}
	
	@RequestMapping(path = BASE_PATH, method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<GestionarUsuarioResponse> processActualizarUsuario(@RequestBody GestionarUsuarioRequest request) {
		final String methodName = "processActualizarUsuario";
		LOGGER.traceEntry(methodName);
		GestionarUsuarioResponse response = new GestionarUsuarioResponse();
		ResponseEntity<GestionarUsuarioResponse> httpResponse = null;
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR; 
		try {
			UserContext context = ContextHolder.get(UserContext.class);
			context.setGestionarRequest(request);
			context.setGestionarResponse(response);

			processService.actualizar();

			response = context.getGestionarResponse();
			httpStatus = HttpStatus.OK; 
		} catch (BackEndException e) {
			response.setStatus(Utils.buildErrorValidationStatus(e));
		} catch (Exception e) {
			response.setStatus(Utils.buildErrorStatus(e));
		} 
		httpResponse = new ResponseEntity<GestionarUsuarioResponse>(response, httpStatus);
		LOGGER.traceExit();
		return httpResponse;
	}


	@RequestMapping(path = BASE_PATH +"/saldo", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<GestionarSaldoResponse> processRecargarSaldo(@RequestBody GestionarSaldoRequest request) {
		final String methodName = "processRecargarSaldo";
		LOGGER.traceEntry(methodName);
		GestionarSaldoResponse response = new GestionarSaldoResponse();
		ResponseEntity<GestionarSaldoResponse> httpResponse = null;
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR; 
		try {
			UserContext context = ContextHolder.get(UserContext.class);
			context.setGestionarSaldoRequest(request);
			context.setGestionarSaldoResponse(response);

			processService.recargarSaldo();

			response = context.getGestionarSaldoResponse();
			httpStatus = HttpStatus.OK; 
		} catch (BackEndException e) {
			response.setStatus(Utils.buildErrorValidationStatus(e));
		} catch (Exception e) {
			response.setStatus(Utils.buildErrorStatus(e));
		} 
		httpResponse = new ResponseEntity<GestionarSaldoResponse>(response, httpStatus);
		LOGGER.traceExit();
		return httpResponse;
	}
	
	
//	@RequestMapping(path = BASE_PATH + "/{dni}/penalidad", method = RequestMethod.GET)
//    public @ResponseBody ResponseEntity<ConsultaUsuarioPenalidadResponse> consultaUsuarioPenalidad(
//    		@PathVariable(name="dni", required=true)String dni){
//		final String methodName = "consultaUsuarioPenalidad";
//		LOGGER.traceEntry(methodName);
//		ConsultaUsuarioPenalidadResponse response = new ConsultaUsuarioPenalidadResponse();
//		ResponseEntity<ConsultaUsuarioPenalidadResponse> httpResponse = null;
//		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR; 
//		try {
//			UserContext context = ContextHolder.get(UserContext.class);
//			context.setDni(dni);
//			context.setConsultaPenalidadResponse(response);
//
//			processService.consultaPenalidad();
//
//			response = context.getConsultaPenalidadResponse();
//			httpStatus = HttpStatus.OK; 
//		} catch (BackEndException e) {
//			response.setStatus(Utils.buildErrorValidationStatus(e));
//		} catch (Exception e) {
//			response.setStatus(Utils.buildErrorStatus(e));
//		} 
//		httpResponse = new ResponseEntity<ConsultaUsuarioPenalidadResponse>(response, httpStatus);
//		LOGGER.traceExit();
//		return httpResponse;
//	}
	
	@RequestMapping(path = BASE_PATH + "/recuperar", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<GestionarUsuarioResponse> processRecuperarContrasena(@RequestBody GestionarUsuarioRequest request) {
		final String methodName = "processRecuperarContrasena";
		LOGGER.traceEntry(methodName);
		GestionarUsuarioResponse response = new GestionarUsuarioResponse();
		ResponseEntity<GestionarUsuarioResponse> httpResponse = null;
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR; 
		try {
			UserContext context = ContextHolder.get(UserContext.class);
			context.setGestionarRequest(request);
			context.setGestionarResponse(response);

			processService.recuperarContrasena();

			response = context.getGestionarResponse();
			httpStatus = HttpStatus.OK;
		} catch (BackEndException e) {
			response.setStatus(Utils.buildErrorValidationStatus(e));
		} catch (Exception e) {
			response.setStatus(Utils.buildErrorStatus(e));
		} 
		httpResponse = new ResponseEntity<GestionarUsuarioResponse>(response, httpStatus);
		LOGGER.traceExit();
		return httpResponse;
	}

	
	
	
}
