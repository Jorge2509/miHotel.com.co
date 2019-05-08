package co.com.miHotel.modelo.habitacion;
// Generated 05-may-2019 1:08:57 by Hibernate Tools 5.2.12.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.com.miHotel.modelo.incidente.EstadoIncidencia;

/**
 * IncidenteHabitacion generated by hbm2java
 */
@Entity
@Table(name = "incidente_habitacion", schema = "public")
public class IncidenteHabitacion implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idIncidenteHabitacion;
	private EstadoIncidencia estadoIncidencia;
	private Habitacion habitacion;
	private int codigo;
	private Date fechaInicio;
	private Date fechaFin;
	private String descripcion;

	public IncidenteHabitacion() {
	}

	public IncidenteHabitacion(int idIncidenteHabitacion, EstadoIncidencia estadoIncidencia, Habitacion habitacion,
			int codigo, Date fechaInicio, Date fechaFin, String descripcion) {
		this.idIncidenteHabitacion = idIncidenteHabitacion;
		this.estadoIncidencia = estadoIncidencia;
		this.habitacion = habitacion;
		this.codigo = codigo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descripcion = descripcion;
	}

	@Id

	@Column(name = "id_incidente_habitacion", unique = true, nullable = false)
	public int getIdIncidenteHabitacion() {
		return this.idIncidenteHabitacion;
	}

	public void setIdIncidenteHabitacion(int idIncidenteHabitacion) {
		this.idIncidenteHabitacion = idIncidenteHabitacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado_incidencia", nullable = false)
	public EstadoIncidencia getEstadoIncidencia() {
		return this.estadoIncidencia;
	}

	public void setEstadoIncidencia(EstadoIncidencia estadoIncidencia) {
		this.estadoIncidencia = estadoIncidencia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_habitacion", nullable = false)
	public Habitacion getHabitacion() {
		return this.habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	@Column(name = "codigo", nullable = false)
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio", nullable = false, length = 13)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin", nullable = false, length = 13)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Column(name = "descripcion", nullable = false, length = 100)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
