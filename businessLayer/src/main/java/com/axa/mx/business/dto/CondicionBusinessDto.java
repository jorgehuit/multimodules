package com.axa.mx.business.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	
	@Setter
	@Getter
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
	
	@Setter
	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class ProvisionalIdBusinessDto{
		private String descripcion;
	}
}
