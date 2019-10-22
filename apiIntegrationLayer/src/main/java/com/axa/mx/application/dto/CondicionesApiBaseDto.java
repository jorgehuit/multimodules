package com.axa.mx.application.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondicionesApiBaseDto implements Serializable{
	private static final long serialVersionUID = -4662037072631439238L;
	
	private Long id;
	private String idGenerado;
	private String tipo;
	private String titulo;
	private String descripcion;
	private String texto;
	private Integer estatus;

}
