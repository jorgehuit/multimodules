package com.axa.mx.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	
	@Setter
	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CondicionApiOutDto extends CondicionApiDto{
		private Long id;
		
	}
}
