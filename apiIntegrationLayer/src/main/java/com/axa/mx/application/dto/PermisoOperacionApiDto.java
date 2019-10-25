package com.axa.mx.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermisoOperacionApiDto {
	private Long id;
//	private RolModuloApiDto rolModulo;
	private OperacionApiDto operacion;

}
