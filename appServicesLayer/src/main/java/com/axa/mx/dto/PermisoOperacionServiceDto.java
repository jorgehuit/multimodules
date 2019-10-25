package com.axa.mx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermisoOperacionServiceDto {
	private Long id;
//	private RolModuloServiceDto rolModulo;
	private OperacionServiceDto operacion;

}
