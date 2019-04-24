package co.com.miHotel.entidad.reserva;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.com.miHotel.entidad.estado.EstadoIncidente;
import co.com.miHotel.entidad.habitacion.Habitacion;

@Entity
@Table(name = "incidenteHabitacion")
public class IncidenteHabitacion implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idIncidenteHabitacion", nullable = false)
	private int idIncidenteHabitacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idHabitacion")
	private Habitacion Habitacion;

	@Column(name = "codigo")
	private int codigo;

	@Column(name = "fechaInicio")
	private Date fechaInicio;

	@Column(name = "fechaFin")
	private Date fechaFin;

	@Column(name = "descripcion")
	private String descripcion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idInmuebleHabitacion")
	private EstadoIncidente estadoIncidente;

	public int getIdIncidenteHabitacion() {
		return idIncidenteHabitacion;
	}

	public void setIdIncidenteHabitacion(int idIncidenteHabitacion) {
		this.idIncidenteHabitacion = idIncidenteHabitacion;
	}

	public Habitacion getHabitacion() {
		return Habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		Habitacion = habitacion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EstadoIncidente getEstadoIncidente() {
		return estadoIncidente;
	}

	public void setEstadoIncidente(EstadoIncidente estadoIncidente) {
		this.estadoIncidente = estadoIncidente;
	}
}
