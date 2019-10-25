package com.axa.mx.persistence.entity;

import java.util.Date;

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
public class CatOpcionCondicion {
	@Id
	@GeneratedValue
	private Long catOpcionCondicionId;
	private String descripcion;
	private Integer activo;
	private Date fechaAlta;
	private Integer consecutivo;
	private String idProvisional;
}
