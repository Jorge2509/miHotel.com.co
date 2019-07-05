package co.com.miHotel.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_incidencia database table.
 * 
 */
@Entity
@Table(name="estado_incidencia")
@NamedQuery(name="EstadoIncidencia.findAll", query="SELECT e FROM EstadoIncidencia e")
public class EstadoIncidencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_incidencia")
	private Integer idEstadoIncidencia;

	@Column(name="descripcion")
	private String descripcion;

	public EstadoIncidencia() {
	}

	public Integer getIdEstadoIncidencia() {
		return this.idEstadoIncidencia;
	}

	public void setIdEstadoIncidencia(Integer idEstadoIncidencia) {
		this.idEstadoIncidencia = idEstadoIncidencia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "EstadoIncidencia [idEstadoIncidencia=" + idEstadoIncidencia + ", descripcion=" + descripcion + "]";
	}
}