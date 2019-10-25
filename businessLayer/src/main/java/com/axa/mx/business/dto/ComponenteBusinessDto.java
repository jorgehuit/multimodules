
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
public class ComponenteBusinessDto {
	private Long id;
	private String claveComponente;
	private String nombreComponente;
	private String descripcionComponente;
	private ModuloBusinessDto modulo;
}
