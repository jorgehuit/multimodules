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
public class PermisoComponenteBusinessDto {
	private Long id;
//	private RolModuloBusinessDto rolModulo;
	private ComponenteBusinessDto componente;

}
