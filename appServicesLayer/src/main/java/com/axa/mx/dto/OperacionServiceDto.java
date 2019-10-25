
package com.axa.mx.dto;

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
public class OperacionServiceDto {
	private Long id;
	private String claveOperacion;
	private String nombreOperacion;
	private String descripcionOperacion;
	private boolean admin;
	private ComponenteServiceDto componente;
	private ModuloServiceDto modulo;
}
