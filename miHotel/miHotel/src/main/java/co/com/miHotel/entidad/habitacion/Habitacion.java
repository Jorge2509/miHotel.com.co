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

import co.com.miHotel.entidad.estado.EstadoHabitacion;
import co.com.miHotel.entidad.inmueble.MarcaInmueble;

@Entity
@Table(name = "habitacion")
public class Habitacion implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHabitacion", nullable = false)
	private int idHabitacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoHabitacion")
	private TipoHabitacion tipoHabitacion;
	
	@Column(name = "piso")
	private int piso;
	
	@Column(name = "numeroHabitacion")
	private String numeroHabitacion;

	@Column(name = "precioMaximo")
	private Double precioMaximo;

	@Column(name = "precioMinimo")
	private Double precioMinimo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstadoHabitacion")
	private EstadoHabitacion estadoHabitacion;

	public int getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(String numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public Double getPrecioMaximo() {
		return precioMaximo;
	}

	public void setPrecioMaximo(Double precioMaximo) {
		this.precioMaximo = precioMaximo;
	}

	public Double getPrecioMinimo() {
		return precioMinimo;
	}

	public void setPrecioMinimo(Double precioMinimo) {
		this.precioMinimo = precioMinimo;
	}

	public EstadoHabitacion getEstadoHabitacion() {
		return estadoHabitacion;
	}

	public void setEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
		this.estadoHabitacion = estadoHabitacion;
	}
	
}
