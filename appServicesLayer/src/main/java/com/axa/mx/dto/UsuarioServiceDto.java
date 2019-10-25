package com.axa.mx.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioServiceDto {

	private Long id;
	private String claveUsuario;
	private String claveUsuarioLDAP;
	private String nombreCompleto;
	private String email;
	private boolean activo;
	private Set<UsuarioRolServiceDto> roles = new HashSet<>();
	private Set<EventoServiceDto> eventos = new HashSet<>();

}
