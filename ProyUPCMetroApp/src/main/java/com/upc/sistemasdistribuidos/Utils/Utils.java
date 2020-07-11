package com.upc.sistemasdistribuidos.Utils;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.upc.sistemasdistribuidos.exceptions.BackEndException;
import com.upc.sistemasdistribuidos.type.base.ResponseStatusBase;

public class Utils {
	
	private static final Logger LOGGER = LogManager.getLogger(Utils.class);
	
	public static ResponseStatusBase buildErrorValidationStatus(BackEndException e) {
		LOGGER.error("Error de validacion ", e);
		ResponseStatusBase status = new ResponseStatusBase();
		status.setSuccess(Boolean.FALSE);
		status.setMessage(e.getMessage());
		return status;
	}	
	
	public static ResponseStatusBase buildErrorStatus(Exception e) {
		LOGGER.error("Error interno ", e);
		ResponseStatusBase status = new ResponseStatusBase();
		status.setSuccess(Boolean.FALSE);
		status.setMessage("Error interno " + e.getMessage() + " | " + e.getCause() + " | " + e.toString() + " | " + ExceptionUtils.getFullStackTrace(e));
		return status;
	}

}
