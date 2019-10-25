package com.axa.mx.business.services.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axa.mx.business.dto.UsuarioBusinessDto;
import com.axa.mx.business.exception.ResourceNotFoundException;
import com.axa.mx.business.services.UserBusinessService;
import com.axa.mx.persistence.entity.Usuario;
import com.axa.mx.persistence.repository.UserExaRepository;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class UserBusinessServiceImpl implements UserBusinessService {

	@Autowired
	private UserExaRepository repository;

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public UsuarioBusinessDto getUserByClaveUsuarioLDAP(String username) {
		log.info("Business : buscando usuario...");
		List<Usuario> usuarios = repository.findByClaveUsuarioLDAP(username);
		log.info("Business fin buscando usuario...");
		if (usuarios.isEmpty()) {
			throw new ResourceNotFoundException("No existe el usuario " + username);
		}

		return mapper.map(usuarios.get(0), UsuarioBusinessDto.class);
	}

}
