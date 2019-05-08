package co.com.miHotel.modelo.habitacion;
// Generated 05-may-2019 1:08:57 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.com.miHotel.modelo.persona.Persona;

/**
 * Reserva generated by hbm2java
 */
@Entity
@Table(name = "reserva", schema = "public")
public class Reserva implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idReserva;
	private Habitacion habitacion;
	private Persona persona;
	private Date checkIn;
	private Date checkOut;
	private double precio;
	private Set tiendas = new HashSet(0);

	public Reserva() {
	}

	public Reserva(int idReserva, Habitacion habitacion, Persona persona, Date checkIn, Date checkOut, double precio) {
		this.idReserva = idReserva;
		this.habitacion = habitacion;
		this.persona = persona;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.precio = precio;
	}

	public Reserva(int idReserva, Habitacion habitacion, Persona persona, Date checkIn, Date checkOut, double precio,
			Set tiendas) {
		this.idReserva = idReserva;
		this.habitacion = habitacion;
		this.persona = persona;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.precio = precio;
		this.tiendas = tiendas;
	}

	@Id

	@Column(name = "id_reserva", unique = true, nullable = false)
	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_habitacion", nullable = false)
	public Habitacion getHabitacion() {
		return this.habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona", nullable = false)
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "check_in", nullable = false, length = 35)
	public Date getCheckIn() {
		return this.checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "check_out", nullable = false, length = 35)
	public Date getCheckOut() {
		return this.checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	@Column(name = "precio", nullable = false, precision = 17, scale = 17)
	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reserva")
	public Set getTiendas() {
		return this.tiendas;
	}

	public void setTiendas(Set tiendas) {
		this.tiendas = tiendas;
	}

}
