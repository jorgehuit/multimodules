package com.axa.mx.business.exception;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6619593122266075473L;

	public static final String MSG_ERROR_404 = "Elementos no encontrados";

	public static final int CODE_ERROR = 500;
	public static final int CODE_NOT_FOUND = 404;

	public ResourceNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public ResourceNotFoundException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}

}
