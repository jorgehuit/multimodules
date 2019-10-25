package com.axa.mx.business.services;

import com.axa.mx.business.dto.UsuarioBusinessDto;

public interface UserBusinessService {

	UsuarioBusinessDto getUserByClaveUsuarioLDAP(String username);

}
