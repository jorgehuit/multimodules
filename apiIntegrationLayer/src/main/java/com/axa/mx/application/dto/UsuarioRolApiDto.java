package com.axa.mx.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRolApiDto {

	private Long id;
//	private UsuarioApiDto usuario;
	private RolModuloApiDto rolModulo;
}
