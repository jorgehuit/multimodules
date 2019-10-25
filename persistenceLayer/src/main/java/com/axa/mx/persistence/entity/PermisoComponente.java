package com.axa.mx.persistence.entity;

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
@Table(name = "PERMISOSCOMP")
public class PermisoComponente {
	@Id
	@GeneratedValue
	@Column(name = "OID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLESMODULO_OID", nullable = false)
	private RolModulo rolModulo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPONENTES_OID", nullable = false)
	private Componente componente;

}
