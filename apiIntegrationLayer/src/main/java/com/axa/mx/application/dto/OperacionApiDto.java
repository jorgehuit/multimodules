
package com.axa.mx.application.dto;

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
public class OperacionApiDto {
	private Long id;
	private String claveOperacion;
	private String nombreOperacion;
	private String descripcionOperacion;
	private boolean admin;
	private ComponenteApiDto componente;
	private ModuloApiDto modulo;
}
