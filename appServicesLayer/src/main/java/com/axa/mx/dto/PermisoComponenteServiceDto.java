package com.axa.mx.dto;

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
public class PermisoComponenteServiceDto {
	private Long id;
//	private RolModuloServiceDto rolModulo;
	private ComponenteServiceDto componente;

}
