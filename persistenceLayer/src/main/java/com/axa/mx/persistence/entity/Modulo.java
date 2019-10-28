
package com.axa.mx.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author lreyesve
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MODULOS")
public class Modulo {
	@Id
	@GeneratedValue
	@Column(name = "OID")
	private Long id;

	@Column(name = "CVEMODULO", length = 20, nullable = false)
	private String claveModulo;

	@Column(name = "NOMMODULO", length = 50, nullable = false)
	private String nombreModulo;
}
