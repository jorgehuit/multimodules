package com.axa.mx.persistence.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "ROLESMODULO")
public class RolModulo {
	@Id
	@GeneratedValue
	@Column(name = "OID")
	private Long id;

	@Column(name = "CVEROL", length = 20)
	private String claveRol;

	@Column(name = "NOMROL", length = 50)
	private String nombreRol;

	@Column(name = "DESCROL", length = 255)
	private String descripcionRol;

	@OneToMany(mappedBy = "rolModulo")
	private Set<PermisoComponente> permisosComponente = new HashSet<>();

	@OneToMany(mappedBy = "rolModulo")
	private Set<PermisoOperacion> permisosOperacion = new HashSet<>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RolModulo other = (RolModulo) obj;
		return Objects.equals(claveRol, other.claveRol) && Objects.equals(descripcionRol, other.descripcionRol)
				&& Objects.equals(id, other.id) && Objects.equals(nombreRol, other.nombreRol);
	}

	@Override
	public int hashCode() {
		return Objects.hash(claveRol, descripcionRol, id, nombreRol);
	}

	@Override
	public String toString() {
		return "RolModulo [id=" + id + ", claveRol=" + claveRol + ", nombreRol=" + nombreRol + ", descripcionRol="
				+ descripcionRol + "]";
	}

}
