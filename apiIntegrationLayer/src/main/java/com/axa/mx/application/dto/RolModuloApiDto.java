package com.axa.mx.application.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolModuloApiDto {

	private Long id;
	private String claveRol;
	private String nombreRol;
	private String descripcionRol;
	private Set<PermisoComponenteApiDto> permisosComponente = new HashSet<>();
	private Set<PermisoOperacionApiDto> permisosOperacion = new HashSet<>();

}
