package com.axa.mx.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axa.mx.application.dto.DataApi;

@RestController
public class ApiController {

	@Autowired
	private BuildProperties buildProperties;

	@Autowired
	private MessageSource messageSource;

	// ------------ Devuelve versión deployada en servidor ------------ //

	@GetMapping(value = "/getInfoVersion")
	public ResponseEntity<DataApi> getInfoVersion() {
		return new ResponseEntity<DataApi>(new DataApi(buildProperties.getVersion()), HttpStatus.OK);
	}

	// ------------ Devuelve Hello world con Internacionalizacion ------------ //
	@GetMapping(value = "getHello")
	public ResponseEntity<DataApi> getHello() {
		return new ResponseEntity<DataApi>(
				new DataApi(messageSource.getMessage("welcome.user", new String[] {"Jorge"}, LocaleContextHolder.getLocale())),
				HttpStatus.OK);
	}

}
