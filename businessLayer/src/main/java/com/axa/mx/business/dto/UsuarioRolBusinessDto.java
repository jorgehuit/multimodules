package com.axa.mx.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author lreyesve
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRolBusinessDto {

	private Long id;
//	private UsuarioBusinessDto usuario;
	private RolModuloBusinessDto rolModulo;
}
