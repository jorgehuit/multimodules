
package com.axa.mx.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "OPERACIONES")
public class Operacion {
	@Id
	@GeneratedValue
	@Column(name = "OID")
	private Long id;

	@Column(name = "CVEOPER", length = 20, nullable = false)
	private String claveOperacion;

	@Column(name = "NOMOPER", length = 50, nullable = false)
	private String nombreOperacion;

	@Column(name = "DESCOPER", length = 255)
	private String descripcionOperacion;

	@Column(name = "ESADMIN", nullable = false)
	private boolean admin;

	@ManyToOne
	@JoinColumn(name = "COMPONENTES_OID")
	private Componente componente;

	@ManyToOne
	@JoinColumn(name = "MODULOS_OID")
	private Modulo modulo;
}
