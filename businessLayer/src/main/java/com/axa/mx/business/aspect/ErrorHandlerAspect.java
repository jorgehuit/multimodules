package com.axa.mx.business.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.axa.mx.business.dto.CustomErrorResponseDTO;
import com.axa.mx.business.exception.FeignException;
import com.axa.mx.business.exception.ResourceNotFoundException;

import lombok.extern.log4j.Log4j;

@Log4j
@ControllerAdvice
public class ErrorHandlerAspect {
	private static final String MSG_INTERNAL_ERROR = "Internal server error";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomErrorResponseDTO> handleNotFound(ResourceNotFoundException ex) {

		log.error(ex.getMessage(), ex);

		CustomErrorResponseDTO errorResponse = new CustomErrorResponseDTO(ResourceNotFoundException.CODE_NOT_FOUND,
				ex.getMessage(), simpleDateFormat.format(new Date()));

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<CustomErrorResponseDTO> feignException(FeignException ex) {
		
		log.error(ex.getMessage(), ex);
		
		CustomErrorResponseDTO errorResponse = new CustomErrorResponseDTO(FeignException.CODE_TIME_OUT,
				ex.getMessage(), simpleDateFormat.format(new Date()));
		
		return new ResponseEntity<>(errorResponse, HttpStatus.REQUEST_TIMEOUT);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomErrorResponseDTO> handleInternalError(Exception ex) {

		log.error(ex.getMessage(), ex);

		CustomErrorResponseDTO errorResponse = new CustomErrorResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				MSG_INTERNAL_ERROR, simpleDateFormat.format(new Date()));

		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
