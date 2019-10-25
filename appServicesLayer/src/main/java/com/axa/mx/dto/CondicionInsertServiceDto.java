package com.axa.mx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondicionInsertServiceDto {

	private String tipo;
	private String titulo;
	private String descripcion;
	private String texto;
	private String idGenerado;
	
}
