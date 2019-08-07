package co.com.miHotel.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the habitacion database table.
 * 
 */
@Entity
@NamedQuery(name="Habitacion.findAll", query="SELECT h FROM Habitacion h")
public class Habitacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_habitacion")
	private Integer idHabitacion;

	@Column(name="numero_habitacion")
	private String numeroHabitacion;

	@Column(name="piso")
	private Integer piso;

	@Column(name="precio_maximo")
	private double precioMaximo;

	@Column(name="precio_minimo")
	private double precioMinimo;

	//bi-directional many-to-one association to EstadoHabitacion
	@ManyToOne
	@JoinColumn(name="id_estado_habitacion")
	private EstadoHabitacion estadoHabitacion;

	//bi-directional many-to-one association to TipoHabitacion
	@ManyToOne
	@JoinColumn(name="id_tipo_habitacion")
	private TipoHabitacion tipoHabitacion;

	@Column(name="imagen")
	private String imagen;
	public Habitacion() {
	}

	public Integer getIdHabitacion() {
		return this.idHabitacion;
	}

	public void setIdHabitacion(Integer idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public String getNumeroHabitacion() {
		return this.numeroHabitacion;
	}

	public void setNumeroHabitacion(String numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public Integer getPiso() {
		return this.piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public double getPrecioMaximo() {
		return this.precioMaximo;
	}

	public void setPrecioMaximo(double precioMaximo) {
		this.precioMaximo = precioMaximo;
	}

	public double getPrecioMinimo() {
		return this.precioMinimo;
	}

	public void setPrecioMinimo(double precioMinimo) {
		this.precioMinimo = precioMinimo;
	}

	public EstadoHabitacion getEstadoHabitacion() {
		return this.estadoHabitacion;
	}

	public void setEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
		this.estadoHabitacion = estadoHabitacion;
	}

	public TipoHabitacion getTipoHabitacion() {
		return this.tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Habitacion [idHabitacion=" + idHabitacion + ", numeroHabitacion=" + numeroHabitacion + ", piso=" + piso
				+ ", precioMaximo=" + precioMaximo + ", precioMinimo=" + precioMinimo + ", estadoHabitacion="
				+ estadoHabitacion + ", tipoHabitacion=" + tipoHabitacion + "]";
	}

}