package com.axa.mx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRolServiceDto {

	private Long id;
//	private UsuarioServiceDto usuario;
	private RolModuloServiceDto rolModulo;
}
