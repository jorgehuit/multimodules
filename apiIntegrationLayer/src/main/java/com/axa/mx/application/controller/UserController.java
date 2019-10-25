package com.axa.mx.application.controller;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axa.mx.application.dto.UsuarioApiDto;
import com.axa.mx.dto.UsuarioServiceDto;
import com.axa.mx.service.UserService;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "http://localhost:4200" })
@Log4j
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private DozerBeanMapper mapper;

	@GetMapping(value = "/")
	public ResponseEntity<UsuarioApiDto> getByUserName(@RequestHeader("username") String username) {
		log.info("Controller buscando usuario...");
		UsuarioServiceDto usuario = userService.getUserByClaveUsuarioLDAP(username);
		log.info("Controller fin buscando usuario...");
		return new ResponseEntity<>(mapper.map(usuario, UsuarioApiDto.class), HttpStatus.OK);
	}

}
