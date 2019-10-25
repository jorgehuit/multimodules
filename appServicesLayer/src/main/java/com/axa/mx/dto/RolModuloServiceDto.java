package com.axa.mx.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolModuloServiceDto {

	private Long id;
	private String claveRol;
	private String nombreRol;
	private String descripcionRol;
	private Set<PermisoComponenteServiceDto> permisosComponente = new HashSet<>();
	private Set<PermisoOperacionServiceDto> permisosOperacion = new HashSet<>();

}
