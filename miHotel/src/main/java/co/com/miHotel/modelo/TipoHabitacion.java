package co.com.miHotel.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the tipo_habitacion database table.
 * 
 */
@Entity
@Table(name = "tipo_habitacion")
@NamedQuery(name = "TipoHabitacion.findAll", query = "SELECT t FROM TipoHabitacion t")
public class TipoHabitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_habitacion")
	private Integer idTipoHabitacion;
	
	@Column(name = "descripcion")
	private String descripcion;

	public TipoHabitacion() {
	}

	public Integer getIdTipoHabitacion() {
		return this.idTipoHabitacion;
	}

	public void setIdTipoHabitacion(Integer idTipoHabitacion) {
		this.idTipoHabitacion = idTipoHabitacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoHabitacion [idTipoHabitacion=" + idTipoHabitacion + ", descripcion=" + descripcion + "]";
	}
}