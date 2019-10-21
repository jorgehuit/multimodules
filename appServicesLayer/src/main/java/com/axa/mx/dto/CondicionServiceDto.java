package com.axa.mx.dto;

import java.util.List;

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
	public static class CondicionServiceOutDto extends CondicionServiceDto{
		private Long id;
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ListCondicionServiceOutDto {
		private List<CondicionServiceOutDto> listCondicionServiceOutDto;
	}
}
