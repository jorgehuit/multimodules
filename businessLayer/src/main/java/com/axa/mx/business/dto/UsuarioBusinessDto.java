package com.axa.mx.business.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author lreyesve
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioBusinessDto {

	private Long id;
	private String claveUsuario;
	private String claveUsuarioLDAP;
	private String nombreCompleto;
	private String email;
	private boolean activo;
	private Set<UsuarioRolBusinessDto> roles = new HashSet<>();
	private Set<EventoBusinessDto> eventos = new HashSet<>();

}
