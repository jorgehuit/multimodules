
package com.axa.mx.business.dto;

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
public class OperacionBusinessDto {
	private Long id;
	private String claveOperacion;
	private String nombreOperacion;
	private String descripcionOperacion;
	private boolean admin;
	private ComponenteBusinessDto componente;
	private ModuloBusinessDto modulo;
}
