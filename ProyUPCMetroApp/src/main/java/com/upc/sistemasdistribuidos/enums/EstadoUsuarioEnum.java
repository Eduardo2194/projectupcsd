package com.upc.sistemasdistribuidos.enums;

public enum EstadoUsuarioEnum {
	
	ELIMINADO(0),
	ACTIVO(1),
	SUSPENDIDO(2);
	
	private final Integer code;
	
	private EstadoUsuarioEnum(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static EstadoUsuarioEnum getByCode(Integer code) {
		EstadoUsuarioEnum value = null;
		for (EstadoUsuarioEnum item : EstadoUsuarioEnum.values()) {
			if (item.getCode().equals(code)) {
				value = item;
				break;
			}
		}
		return value;
	}
	
}
