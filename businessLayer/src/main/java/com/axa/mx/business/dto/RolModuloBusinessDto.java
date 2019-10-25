package com.axa.mx.business.dto;

import java.util.HashSet;
import java.util.Set;

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
public class RolModuloBusinessDto {

	private Long id;
	private String claveRol;
	private String nombreRol;
	private String descripcionRol;
	private Set<PermisoComponenteBusinessDto> permisosComponente = new HashSet<>();
	private Set<PermisoOperacionBusinessDto> permisosOperacion = new HashSet<>();

}
