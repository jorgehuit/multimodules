package com.axa.mx.business.exception;

public class FeignException extends RuntimeException  {

	private static final long serialVersionUID = -3601616312500285481L;
	public static final Integer CODE_TIME_OUT = 408;
	
	public FeignException(String errorMessage) {
		super(errorMessage);
	}

	public FeignException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}
	

}
