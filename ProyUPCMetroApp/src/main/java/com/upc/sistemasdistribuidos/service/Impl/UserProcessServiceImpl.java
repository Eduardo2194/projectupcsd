package com.upc.sistemasdistribuidos.service.Impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.sistemasdistribuidos.bussines.MovimientoRest;
import com.upc.sistemasdistribuidos.bussines.UsuarioRest;
import com.upc.sistemasdistribuidos.context.ContextHolder;
import com.upc.sistemasdistribuidos.context.UserContext;
import com.upc.sistemasdistribuidos.dao.SaldoDAO;
import com.upc.sistemasdistribuidos.dao.UsuarioDAO;
import com.upc.sistemasdistribuidos.enums.EstadoUsuarioEnum;
import com.upc.sistemasdistribuidos.enums.TipoUsuarioEnum;
import com.upc.sistemasdistribuidos.exceptions.BackEndException;
import com.upc.sistemasdistribuidos.model.Movimiento;
import com.upc.sistemasdistribuidos.model.Usuario;
import com.upc.sistemasdistribuidos.request.GestionarSaldoRequest;
import com.upc.sistemasdistribuidos.request.GestionarUsuarioRequest;
import com.upc.sistemasdistribuidos.request.LoginUsuarioRequest;
import com.upc.sistemasdistribuidos.response.GestionarSaldoResponse;
import com.upc.sistemasdistribuidos.response.GestionarUsuarioResponse;
import com.upc.sistemasdistribuidos.response.LoginUsuarioResponse;
import com.upc.sistemasdistribuidos.service.UserProcessService;
import com.upc.sistemasdistribuidos.service.ValidationService;
import com.upc.sistemasdistribuidos.type.base.ResponseStatusBase;



@Service
public class UserProcessServiceImpl implements UserProcessService {

	private static final Logger LOGGER = LogManager.getLogger(UserProcessServiceImpl.class);

	@Autowired
	private ValidationService validationService;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private SaldoDAO saldoDAO;
//	
//	@Autowired
//	private PenalidadDAO penalidadDAO;
	
	@Override
	public void login() {
		final String methodName = "login";
		LOGGER.traceEntry(methodName);
		
		validationService.validateLoginParams();
		
		UserContext context = ContextHolder.get(UserContext.class);
		LoginUsuarioRequest request = context.getLoginRequest();
		LoginUsuarioResponse response= context.getLoginResponse();
		
		LOGGER.info("Intentando iniciar sesion con dni : "+request.getUsuario().getDni());
		List<Integer> invalidStates = Arrays.asList(0);
		Usuario usuario = usuarioDAO.recuperarUsuarioPorDNI(request.getUsuario().getDni(), invalidStates);
		
		if (usuario == null) {
			LOGGER.info("No se encontro al usuario");
			throw new BackEndException("El usuario no se encuentra registrado");
		} 
		
		LOGGER.info("Se encontro al usuario");
		
		if (usuario.getContrasena() == null || !usuario.getContrasena().equals(request.getUsuario().getContrasena())) {
			LOGGER.info("La contraseña es inválida");
			throw new BackEndException("Contraseña inválida");
		} 
		
		EstadoUsuarioEnum estadoUsuario = EstadoUsuarioEnum.getByCode(usuario.getEstado());
		TipoUsuarioEnum tipoUsuario = TipoUsuarioEnum.getByCode(usuario.getCodigoTipo());
		if (estadoUsuario == null || tipoUsuario == null) {
			throw new BackEndException("La información del usuario es inválida o corrupta");
		} 
		
		response.setStatus(new ResponseStatusBase());
		response.getStatus().setSuccess(Boolean.TRUE);
		response.getStatus().setMessage("Logueo OK");
		
		response.setUsuario(new UsuarioRest());
		response.getUsuario().setIdentifier(usuario.getId());
		response.getUsuario().setNombres(usuario.getNombres());
		response.getUsuario().setApellidos(usuario.getApellidos());
		response.getUsuario().setCelular(usuario.getCelular());
		response.getUsuario().setDni(usuario.getDni());
		response.getUsuario().setCorreo(usuario.getCorreo());
		response.getUsuario().setEstado(estadoUsuario.name());
		response.getUsuario().setTipo(tipoUsuario.name());
		response.getUsuario().setContrasena(usuario.getContrasena());
		response.getUsuario().setSaldo(usuario.getSaldo());
	
		LOGGER.traceExit(methodName);
	}

	@Override
	public void registrar() {
		final String methodName = "registrar";
		LOGGER.traceEntry(methodName);
		
		validationService.validateRegistroParams();
		
		UserContext context = ContextHolder.get(UserContext.class);
		GestionarUsuarioRequest request= context.getGestionarRequest();
		GestionarUsuarioResponse response= context.getGestionarResponse();
		
		List<Integer> invalidStates = Arrays.asList(EstadoUsuarioEnum.ELIMINADO.getCode());
		Usuario usuarioExistente = usuarioDAO.recuperarUsuarioPorDNI(request.getUsuario().getDni(), invalidStates);
		
		if (usuarioExistente != null) {
			LOGGER.info("El usuario ya se encuentra registrado");
			throw new BackEndException("Ya existe un usuario registrado para el dni ingresado");
		} 
		
		
		Usuario usuarioARegistrar = new Usuario();
		usuarioARegistrar.setNombres(request.getUsuario().getNombres());
		usuarioARegistrar.setApellidos(request.getUsuario().getApellidos());
		usuarioARegistrar.setCelular(request.getUsuario().getCelular());
		usuarioARegistrar.setDni(request.getUsuario().getDni());
		usuarioARegistrar.setCorreo(request.getUsuario().getCorreo());
		usuarioARegistrar.setContrasena(request.getUsuario().getContrasena());
		usuarioARegistrar.setFechaRegistro(new Date());
		usuarioARegistrar.setSaldo(request.getUsuario().getSaldo());
		TipoUsuarioEnum tipoUsuario = TipoUsuarioEnum.getByCode(request.getUsuario().getTipo());
		if (tipoUsuario == null || tipoUsuario == TipoUsuarioEnum.ADMIN) {
			throw new BackEndException("El tipo de usuario es inválido");
		}
		usuarioARegistrar.setCodigoTipo(tipoUsuario.getCode());
		
		switch (tipoUsuario) {
		case PASAJERO:
			usuarioARegistrar.setEstado(EstadoUsuarioEnum.ACTIVO.getCode());
			break;
		case CAJERO:
			context.setUserRestEntity(request.getUsuario());
//			validationService.validateMecanicoExclusiveParams();
		default:
			throw new BackEndException("El tipo de usuario es inválido");
		}
		
		Usuario usuario = usuarioDAO.registrarUsuario(usuarioARegistrar);
		
		if(usuario!=null) {
			
			response.setStatus(new ResponseStatusBase());
			response.getStatus().setSuccess(Boolean.TRUE);
			response.getStatus().setMessage("Registro OK");
			
			response.setUsuario(new UsuarioRest());
			response.getUsuario().setIdentifier(usuario.getId());
			response.getUsuario().setNombres(usuario.getNombres());
			response.getUsuario().setApellidos(usuario.getApellidos());
			response.getUsuario().setCelular(usuario.getCelular());
			response.getUsuario().setDni(usuario.getDni());
			response.getUsuario().setCorreo(usuario.getCorreo());
			response.getUsuario().setTipo(request.getUsuario().getTipo());
			response.getUsuario().setSaldo(request.getUsuario().getSaldo());
			response.getUsuario().setEstado(String.valueOf(EstadoUsuarioEnum.ACTIVO.getCode()));
			response.getUsuario().setContrasena(usuario.getContrasena());

		} else {
			throw new BackEndException("No se pudo registrar al usuario");
		}
		LOGGER.traceExit(methodName);
	}

	@Override
	public void actualizar() {
		final String methodName = "actualizar";
		LOGGER.traceEntry(methodName);
		
		UserContext context = ContextHolder.get(UserContext.class);
		GestionarUsuarioRequest request= context.getGestionarRequest();
		GestionarUsuarioResponse response= context.getGestionarResponse();
		
		List<Integer> invalidStates = Arrays.asList(EstadoUsuarioEnum.ELIMINADO.getCode());
		Usuario usuarioExistente = usuarioDAO.recuperarUsuarioPorDNI(request.getUsuario().getDni(), invalidStates);
		
		if (usuarioExistente == null) {
			LOGGER.info("El usuario enviado a actualizar no existe");
			throw new BackEndException("El usuario enviado a actualizar no existe");
		} 
		
		UsuarioRest usuarioFromRequest = request.getUsuario();
		if (usuarioFromRequest.getNombres() != null && !usuarioFromRequest.getNombres().trim().isEmpty()) {
			usuarioExistente.setNombres(usuarioFromRequest.getNombres());
		}
		
		if (usuarioFromRequest.getApellidos() != null && !usuarioFromRequest.getApellidos().trim().isEmpty()) {
			usuarioExistente.setApellidos(usuarioFromRequest.getApellidos());
		} 
		
		if (usuarioFromRequest.getCelular() != null && !usuarioFromRequest.getCelular().trim().isEmpty()) {
			usuarioExistente.setCelular(usuarioFromRequest.getCelular());
		}
		
		if (usuarioFromRequest.getCorreo() != null && !usuarioFromRequest.getCorreo().trim().isEmpty()) {
			usuarioExistente.setCorreo(usuarioFromRequest.getCorreo());
		} 
		
		if (usuarioFromRequest.getContrasena() != null && !usuarioFromRequest.getContrasena().trim().isEmpty()) {
			usuarioExistente.setContrasena(usuarioFromRequest.getContrasena());
		} 
		
		TipoUsuarioEnum tipoUsuario = TipoUsuarioEnum.getByCode(usuarioExistente.getCodigoTipo());
		if (tipoUsuario == null) {
			throw new BackEndException("El tipo de usuario es inválido, data corrupta");
		}
		
		Usuario usuarioActualizado = usuarioDAO.actualizarUsuario(usuarioExistente);
		
		if (usuarioActualizado == null) {
			throw new BackEndException("No se pudo actualizar los datos del usuario");
		}
		
		response.setStatus(new ResponseStatusBase());
		response.getStatus().setSuccess(Boolean.TRUE);
		response.getStatus().setMessage("Actualizacion OK");
		
		response.setUsuario(new UsuarioRest());
		response.getUsuario().setIdentifier(usuarioActualizado.getId());
		response.getUsuario().setNombres(usuarioActualizado.getNombres());
		response.getUsuario().setApellidos(usuarioActualizado.getApellidos());
		response.getUsuario().setCelular(usuarioActualizado.getCelular());
		response.getUsuario().setDni(usuarioActualizado.getDni());
		response.getUsuario().setCorreo(usuarioActualizado.getCorreo());
		response.getUsuario().setTipo(tipoUsuario.getCode());
		
		LOGGER.traceExit(methodName);
	}

	
	
	@Override
	public void recargarSaldo() {
		final String methodName = "registrar saldo";
		LOGGER.traceEntry(methodName);
		
		UserContext context = ContextHolder.get(UserContext.class);
		GestionarSaldoRequest request= context.getGestionarSaldoRequest();
		GestionarSaldoResponse response= context.getGestionarSaldoResponse();
		
		List<Integer> invalidStates = Arrays.asList(EstadoUsuarioEnum.ELIMINADO.getCode());
		Usuario usuarioExistente = usuarioDAO.recuperarUsuarioPorDNI(request.getUsuario().getDni(), invalidStates);
		
		if (usuarioExistente == null) {
			LOGGER.info("El usuario enviado no existe");
			throw new BackEndException("El usuario enviado no existe");
		} 
		
		MovimientoRest movimientoFromRequest = request.getMovimiento();
		
		if (movimientoFromRequest == null || movimientoFromRequest.getMonto().isEmpty()) {
			LOGGER.info("Debe ingresar un monto");
			throw new BackEndException("Debe ingresar un monto");	
		}else if(new Double(movimientoFromRequest.getMonto())<3) {
			LOGGER.info("La recarga debe ser mayor a 3 soles");
			throw new BackEndException("El saldo debe ser mayor a 3 soles");	
		}
		else {
			usuarioExistente.setSaldo(usuarioExistente.getSaldo()+ new Double(request.getMovimiento().getMonto()));
		}
		
	    Movimiento movimientoRegistrar = new Movimiento();
	    movimientoRegistrar.setId(request.getMovimiento().getId());
	    movimientoRegistrar.setIdTipoTransp(request.getMovimiento().getIdTipoTransp());
	    movimientoRegistrar.setIdUsuario(request.getUsuario().getDni());
	    movimientoRegistrar.setMonto(request.getMovimiento().getMonto());
	    movimientoRegistrar.setSaldo(usuarioExistente.getSaldo());
	    movimientoRegistrar.setFechaRegistro(new Date());
	    movimientoRegistrar.setTipoMov(request.getMovimiento().getTipoMov());
		
		Usuario usuarioActualizado = usuarioDAO.actualizarUsuario(usuarioExistente);
		Movimiento movimiento = saldoDAO.registrarUsuario(movimientoRegistrar);
		
		
		if (usuarioActualizado == null || movimiento == null) {
			throw new BackEndException("No se pudo realizar la recarga");
		}
		
		response.setStatus(new ResponseStatusBase());
		response.getStatus().setSuccess(Boolean.TRUE);
		response.getStatus().setMessage("Recarga OK");
		
		LOGGER.traceExit(methodName);
	}	
	
	
	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recuperarContrasena() {
		final String methodName = "recuperarContrasena";
		LOGGER.traceEntry(methodName);
		
		UserContext context = ContextHolder.get(UserContext.class);
		GestionarUsuarioRequest request = context.getGestionarRequest();
		GestionarUsuarioResponse response = context.getGestionarResponse();
		
		List<Integer> invalidStates = Arrays.asList(EstadoUsuarioEnum.ELIMINADO.getCode());
		Usuario usuarioExistente = usuarioDAO.recuperarUsuarioPorDNI(request.getUsuario().getDni(), invalidStates);
		
		if (usuarioExistente == null) {
			LOGGER.info("El usuario no existe");
			throw new BackEndException("El usuario no existe");
		}
		
		if (usuarioExistente.getCorreo() == null || usuarioExistente.getCorreo().trim().isEmpty()) {
			LOGGER.info("El correo registrado es invalido");
			throw new BackEndException("El correo registrado es invalido");
		}	
		final String username = "metropagoap@gmail.com";
        final String password = "AB123456c";
        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("metropagoapc@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(usuarioExistente.getCorreo())
            );
            message.setSubject("Recuperación de Contraseña");
            message.setText("Estimado "+usuarioExistente.getNombres()+","
                    + "\n\n Por favor ingrese a https://web-upc-tp1.azurewebsites.net/RecoveryPassword.aspx?token="+usuarioExistente.getDni()
            		+ "\n\n Atentamente, MetroPagoApp");
            Transport.send(message);
            LOGGER.info("Se envio el mensaje");
        } catch (Exception e) {
        	LOGGER.error("No se pudo enviar el correo de recuperación", e);
            throw new BackEndException("No se pudo enviar el correo de recuperación");
        }
		response.setStatus(new ResponseStatusBase());
		response.getStatus().setSuccess(Boolean.TRUE);
		response.getStatus().setMessage("Se envio un mensaje a su correo electronico");
	}
	
}
