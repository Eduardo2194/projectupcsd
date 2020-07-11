package com.upc.sistemasdistribuidos.enums;

public enum TipoUsuarioEnum {
	
	ADMIN("ADMIN"),
	PASAJERO("PASAJERO"),
	CAJERO("CAJERO");
	
	private final String code;
	
	private TipoUsuarioEnum(String code) {
		this.code = code;
	}
	
	public static TipoUsuarioEnum getByCode(String code) {
		TipoUsuarioEnum value = null;
		for (TipoUsuarioEnum item : TipoUsuarioEnum.values()) {
			if (item.getCode().equals(code)) {
				value = item;
				break;
			}
		}
		return value;
	}

	public String getCode() {
		return code;
	}
	
	

}
