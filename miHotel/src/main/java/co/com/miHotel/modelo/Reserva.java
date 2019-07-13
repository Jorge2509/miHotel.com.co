package co.com.miHotel.modelo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the reserva database table.
 * 
 */
@Entity
@NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva")
	private Integer idReserva;

	@Column(name = "check_in")
	private Timestamp checkIn;

	@Column(name = "check_out")
	private Timestamp checkOut;

	@Column(name = "precio")
	private double precio;

	// bi-directional many-to-one association to Habitacion
	@ManyToOne
	@JoinColumn(name = "id_habitacion")
	private Habitacion habitacion;

	// bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name = "id_persona")
	private Persona persona;

	public Reserva() {
	}

	public Integer getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Timestamp getCheckIn() {
		return this.checkIn;
	}

	public void setCheckIn(Timestamp checkIn) {
		this.checkIn = checkIn;
	}

	public Timestamp getCheckOut() {
		return this.checkOut;
	}

	public void setCheckOut(Timestamp checkOut) {
		this.checkOut = checkOut;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", precio="
				+ precio + ", habitacion=" + habitacion + ", persona=" + persona + "]";
	}
	
}