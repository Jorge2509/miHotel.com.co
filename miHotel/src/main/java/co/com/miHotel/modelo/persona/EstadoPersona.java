package co.com.miHotel.modelo.persona;
// Generated 05-may-2019 1:08:57 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * EstadoPersona generated by hbm2java
 */
@Entity
@Table(name = "estado_persona", schema = "public")
public class EstadoPersona implements java.io.Serializable {

	private int idEstadoPersona;
	private String descripcion;
	private Set personas = new HashSet(0);

	public EstadoPersona() {
	}

	public EstadoPersona(int idEstadoPersona, String descripcion) {
		this.idEstadoPersona = idEstadoPersona;
		this.descripcion = descripcion;
	}

	public EstadoPersona(int idEstadoPersona, String descripcion, Set personas) {
		this.idEstadoPersona = idEstadoPersona;
		this.descripcion = descripcion;
		this.personas = personas;
	}

	@Id

	@Column(name = "id_estado_persona", unique = true, nullable = false)
	public int getIdEstadoPersona() {
		return this.idEstadoPersona;
	}

	public void setIdEstadoPersona(int idEstadoPersona) {
		this.idEstadoPersona = idEstadoPersona;
	}

	@Column(name = "descripcion", nullable = false, length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estadoPersona")
	public Set getPersonas() {
		return this.personas;
	}

	public void setPersonas(Set personas) {
		this.personas = personas;
	}

}
