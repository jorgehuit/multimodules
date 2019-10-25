package com.axa.mx.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondicionInsertBusinessDto {

	private String tipo;
	private String titulo;
	private String descripcion;
	private String texto;
	private String idProvisional;
}
