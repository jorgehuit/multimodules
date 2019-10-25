package com.axa.mx.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.axa.mx.persistence.entity.Usuario;

public interface UserExaRepository extends CrudRepository<Usuario, Long> {

	public List<Usuario> findByClaveUsuarioLDAP(String claveUsuarioLDAP);
}
