package com.axa.mx.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condicion {
	@Id
	@GeneratedValue
	private Long id;
	private String idGenerado;
	private String tipo;
	private String titulo;
	private String descripcion;
	private String texto;
	private Integer estatus;

}
