
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
public class ModuloBusinessDto {
	private Long id;
	private String claveModulo;
	private String nombreModulo;
}
