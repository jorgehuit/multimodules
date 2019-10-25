package com.axa.mx.business.dto;

import java.time.LocalDate;

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
public class EventoBusinessDto {
	private Long id;
	private LocalDate fechaEvento;
	private String datosEvento;
//	private UsuarioBusinessDto usuario;
	private OperacionBusinessDto operacion;

}
