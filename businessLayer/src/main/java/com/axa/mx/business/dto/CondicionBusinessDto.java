package com.axa.mx.business.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondicionBusinessDto {
	private String idGenerado;
	private String tipo;
	private String titulo;
	private String descripcion;
	private String texto;
	private Integer estatus;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CondicionBusinessOutDto extends CondicionBusinessDto{
		private Long id;
	}
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ListCondicionBusinessOutDto{
		List<CondicionBusinessOutDto> listCondicionBusinessOutDto;
	}
}
