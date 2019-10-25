
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
public class ComponenteServiceDto {
	private Long id;
	private String claveComponente;
	private String nombreComponente;
	private String descripcionComponente;
	private ModuloServiceDto modulo;
}
