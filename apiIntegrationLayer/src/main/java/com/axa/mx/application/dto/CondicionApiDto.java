package com.axa.mx.application.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondicionApiDto {
	private String idGenerado;
	private String tipo;
	private String titulo;
	private String descripcion;
	private String texto;
	private Integer estatus;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CondicionApiOutDto extends CondicionApiDto{
		private Long id;
		
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ListCondicionApiDto{
		private List<CondicionApiOutDto> listCondicionApiDto;
		
	}
}
