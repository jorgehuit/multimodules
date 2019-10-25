
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
public class ComponenteApiDto {
	private Long id;
	private String claveComponente;
	private String nombreComponente;
	private String descripcionComponente;
	private ModuloApiDto modulo;
}
