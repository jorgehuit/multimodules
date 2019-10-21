package com.axa.mx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondicionServiceDto {
	private String idGenerado;
	private String tipo;
	private String titulo;
	private String descripcion;
	private String texto;
	private Integer estatus;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class InsertCondicionServiceOutDto extends CondicionServiceDto{
		private Long id;
	}
}
