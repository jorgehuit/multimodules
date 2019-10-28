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
@Table(name = "USUARIOS")
public class Usuario {
	@Id
	@GeneratedValue
	@Column(name = "OID")
	private Long id;

	@Column(name = "CVEUSUARIO", length = 255, nullable = false)
	private String claveUsuario;

	@Column(name = "CVEUSUARIO_LDAP", length = 255)
	private String claveUsuarioLDAP;

	@Column(name = "NOMCOMPLETO", length = 255, nullable = false)
	private String nombreCompleto;

	@Column(name = "EMAIL1", length = 255)
	private String email;

	@Column(name = "ESACTIVO", nullable = false)
	private boolean activo;

	@OneToMany(mappedBy = "usuario")
	private Set<UsuarioRol> roles = new HashSet<>();

	@OneToMany(mappedBy = "usuario")
	private Set<Evento> eventos = new HashSet<>();

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
		Usuario other = (Usuario) obj;
		return activo == other.activo && Objects.equals(claveUsuario, other.claveUsuario)
				&& Objects.equals(claveUsuarioLDAP, other.claveUsuarioLDAP) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(nombreCompleto, other.nombreCompleto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(activo, claveUsuario, claveUsuarioLDAP, email, id, nombreCompleto);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", claveUsuario=" + claveUsuario + ", claveUsuarioLDAP=" + claveUsuarioLDAP
				+ ", nombreCompleto=" + nombreCompleto + ", email=" + email + ", activo=" + activo + "]";
	}

}
