
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
public class ModuloApiDto {
	private Long id;
	private String claveModulo;
	private String nombreModulo;
}
