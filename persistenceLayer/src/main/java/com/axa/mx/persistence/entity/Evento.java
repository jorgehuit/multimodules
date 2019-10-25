package com.axa.mx.persistence.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "EVENTOS")
public class Evento {
	@Id
	@GeneratedValue
	@Column(name = "OID")
	private Long id;

	@Column(name = "FECHAEVT", nullable = false)
	private LocalDate fechaEvento;

	@Column(name = "DATOSEVT")
	private String datosEvento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOS_OID", nullable = false)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OPERACIONES_OID", nullable = false)
	private Operacion operacion;

}
