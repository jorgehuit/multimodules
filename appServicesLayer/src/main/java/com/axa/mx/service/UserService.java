package com.axa.mx.service;

import com.axa.mx.dto.UsuarioServiceDto;

public interface UserService {
	UsuarioServiceDto getUserByClaveUsuarioLDAP(String username);
}
