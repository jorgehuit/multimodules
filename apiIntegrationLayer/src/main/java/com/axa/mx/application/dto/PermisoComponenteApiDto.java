package com.axa.mx.application.dto;

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
public class PermisoComponenteApiDto {
	private Long id;
//	private RolModuloApiDto rolModulo;
	private ComponenteApiDto componente;

}
