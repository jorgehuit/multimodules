package com.axa.mx.application.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioApiDto {

	private Long id;
	private String claveUsuario;
	private String claveUsuarioLDAP;
	private String nombreCompleto;
	private String email;
	private boolean activo;
	private Set<UsuarioRolApiDto> roles = new HashSet<>();
	private Set<EventoApiDto> eventos = new HashSet<>();

}
