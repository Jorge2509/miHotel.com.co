package co.com.miHotel.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_habitacion database table.
 * 
 */
@Entity
@Table(name="estado_habitacion")
@NamedQuery(name="EstadoHabitacion.findAll", query="SELECT e FROM EstadoHabitacion e")
public class EstadoHabitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_habitacion")
	private Integer idEstadoHabitacion;

	@Column(name="descripcion")
	private String descripcion;


	public EstadoHabitacion() {
	}

	public Integer getIdEstadoHabitacion() {
		return this.idEstadoHabitacion;
	}

	public void setIdEstadoHabitacion(Integer idEstadoHabitacion) {
		this.idEstadoHabitacion = idEstadoHabitacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "EstadoHabitacion [idEstadoHabitacion=" + idEstadoHabitacion + ", descripcion=" + descripcion + "]";
	}

}