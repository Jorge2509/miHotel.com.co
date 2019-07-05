package co.com.miHotel.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the incidente_inmueble database table.
 * 
 */
@Entity
@Table(name="incidente_inmueble")
@NamedQuery(name="IncidenteInmueble.findAll", query="SELECT i FROM IncidenteInmueble i")
public class IncidenteInmueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_incidente_inmueble")
	private Integer idIncidenteInmueble;

	@Column(name="codigo")
	private Integer codigo;

	@Column(name="descripcion")
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	//bi-directional many-to-one association to EstadoIncidencia
	@ManyToOne
	@JoinColumn(name="id_estado_incidencia")
	private EstadoIncidencia estadoIncidencia;

	//bi-directional many-to-one association to InmuebleHabitacion
	@ManyToOne
	@JoinColumn(name="id_inmueble_habitacion")
	private InmuebleHabitacion inmuebleHabitacion;

	public IncidenteInmueble() {
	}

	public Integer getIdIncidenteInmueble() {
		return this.idIncidenteInmueble;
	}

	public void setIdIncidenteInmueble(Integer idIncidenteInmueble) {
		this.idIncidenteInmueble = idIncidenteInmueble;
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

	public InmuebleHabitacion getInmuebleHabitacion() {
		return this.inmuebleHabitacion;
	}

	public void setInmuebleHabitacion(InmuebleHabitacion inmuebleHabitacion) {
		this.inmuebleHabitacion = inmuebleHabitacion;
	}

	@Override
	public String toString() {
		return "IncidenteInmueble [idIncidenteInmueble=" + idIncidenteInmueble + ", codigo=" + codigo + ", descripcion="
				+ descripcion + ", fechaFin=" + fechaFin + ", fechaInicio=" + fechaInicio + ", estadoIncidencia="
				+ estadoIncidencia + ", inmuebleHabitacion=" + inmuebleHabitacion + "]";
	}
}