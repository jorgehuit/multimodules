package com.axa.mx.service.impl;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axa.mx.business.dto.UsuarioBusinessDto;
import com.axa.mx.business.services.UserBusinessService;
import com.axa.mx.dto.UsuarioServiceDto;
import com.axa.mx.service.UserService;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class UserServiceImpl implements UserService {

	@Autowired
	private DozerBeanMapper mapper;

	@Autowired
	private UserBusinessService userBusiness;

	@Override
	public UsuarioServiceDto getUserByClaveUsuarioLDAP(String username) {
		log.info("Service buscando usuario...");
		UsuarioBusinessDto usuario = userBusiness.getUserByClaveUsuarioLDAP(username);
		return mapper.map(usuario, UsuarioServiceDto.class);
	}

}
