package com.axa.mx.dto;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoServiceDto {
	private Long id;
	private LocalDate fechaEvento;
	private String datosEvento;
//	private UsuarioServiceDto usuario;
	private OperacionServiceDto operacion;

}
