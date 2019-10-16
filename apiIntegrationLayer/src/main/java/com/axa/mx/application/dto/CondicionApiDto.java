package com.axa.mx.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondicionApiDto {
	private String tipo;
	private String titulo;
	private String descripcion;
	private String texto;
}