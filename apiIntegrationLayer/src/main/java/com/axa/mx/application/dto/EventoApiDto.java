package com.axa.mx.application.dto;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoApiDto {
	private Long id;
	private LocalDate fechaEvento;
	private String datosEvento;
//	private UsuarioApiDto usuario;
	private OperacionApiDto operacion;

}
