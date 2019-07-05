package co.com.miHotel.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the incidente_habitacion database table.
 * 
 */
@Entity
@Table(name = "incidente_habitacion")
@NamedQuery(name = "IncidenteHabitacion.findAll", query = "SELECT i FROM IncidenteHabitacion i")
public class IncidenteHabitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_incidente_habitacion")
	private Integer idIncidenteHabitacion;

	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "descripcion")
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio")
	private Date fechaInicio;

	// bi-directional many-to-one association to EstadoIncidencia
	@ManyToOne
	@JoinColumn(name = "id_estado_incidencia")
	private EstadoIncidencia estadoIncidencia;

	// bi-directional many-to-one association to Habitacion
	@ManyToOne
	@JoinColumn(name = "id_habitacion")
	private Habitacion habitacion;

	public IncidenteHabitacion() {
	}

	public Integer getIdIncidenteHabitacion() {
		return this.idIncidenteHabitacion;
	}

	public void setIdIncidenteHabitacion(Integer idIncidenteHabitacion) {
		this.idIncidenteHabitacion = idIncidenteHabitacion;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public EstadoIncidencia getEstadoIncidencia() {
		return this.estadoIncidencia;
	}

	public void setEstadoIncidencia(EstadoIncidencia estadoIncidencia) {
		this.estadoIncidencia = estadoIncidencia;
	}

	public Habitacion getHabitacion1() {
		return this.habitacion;
	}

	public void setHabitacion1(Habitacion habitacion1) {
		this.habitacion = habitacion1;
	}

	@Override
	public String toString() {
		return "IncidenteHabitacion [idIncidenteHabitacion=" + idIncidenteHabitacion + ", codigo=" + codigo
				+ ", descripcion=" + descripcion + ", fechaFin=" + fechaFin + ", fechaInicio=" + fechaInicio
				+ ", estadoIncidencia=" + estadoIncidencia + ", habitacion=" + habitacion + "]";
	}

}