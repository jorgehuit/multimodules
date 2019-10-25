
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
public class ModuloServiceDto {
	private Long id;
	private String claveModulo;
	private String nombreModulo;
}
