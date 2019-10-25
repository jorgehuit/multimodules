
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
@Table(name = "COMPONENTES")
public class Componente {
	@Id
	@GeneratedValue
	@Column(name = "OID")
	private Long id;

	@Column(name = "CVECOMP", length = 20)
	private String claveComponente;

	@Column(name = "NOMCOMP", length = 255, nullable = false)
	private String nombreComponente;

	@Column(name = "DESCCOMP", length = 255)
	private String descripcionComponente;

	@ManyToOne
	@JoinColumn(name = "MODULOS_OID")
	private Modulo modulo;
}
