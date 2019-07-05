package co.com.miHotel.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the inmueble_habitacion database table.
 * 
 */
@Entity
@Table(name = "inmueble_habitacion")
@NamedQuery(name = "InmuebleHabitacion.findAll", query = "SELECT i FROM InmuebleHabitacion i")
public class InmuebleHabitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inmueble_habitacion")
	private Integer idInmuebleHabitacion;

	// bi-directional many-to-one association to Habitacion
	@ManyToOne
	@JoinColumn(name = "id_habitacion")
	private Habitacion habitacion;

	// bi-directional many-to-one association to Inmueble
	@ManyToOne
	@JoinColumn(name = "id_inmueble")
	private Inmueble inmueble;

	public InmuebleHabitacion() {
	}

	public Integer getIdInmuebleHabitacion() {
		return this.idInmuebleHabitacion;
	}

	public void setIdInmuebleHabitacion(Integer idInmuebleHabitacion) {
		this.idInmuebleHabitacion = idInmuebleHabitacion;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	@Override
	public String toString() {
		return "InmuebleHabitacion [idInmuebleHabitacion=" + idInmuebleHabitacion + ", habitacion=" + habitacion
				+ ", inmueble=" + inmueble + "]";
	}
}