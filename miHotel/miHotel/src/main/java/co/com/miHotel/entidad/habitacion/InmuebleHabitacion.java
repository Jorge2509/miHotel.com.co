package co.com.miHotel.entidad.habitacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.com.miHotel.entidad.inmueble.Inmueble;

@Entity
@Table(name = "inmuebleHabitacion")
public class InmuebleHabitacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idInmuebleHabitacion", nullable = false)
	private int idInmuebleHabitacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idHabitacion")
	private Habitacion habitacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idInmueble")
	private Inmueble inmueble;

	public int getIdInmuebleHabitacion() {
		return idInmuebleHabitacion;
	}

	public void setIdInmuebleHabitacion(int idInmuebleHabitacion) {
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
	
}
