package co.com.miHotel.entidad.inmueble;

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

import co.com.miHotel.entidad.estado.EstadoInmueble;

@Entity
@Table(name="inmueble")
public class Inmueble implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idInmueble", nullable = false)
	private int idInmueble;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoInmueble")
	private TipoInmueble tipoInmueble;

	@Column(name = "codigo")
	private int codigo;
	
	@Column(name = "fechaIngreso")
	private Date fechaIngreso;

	@Column(name = "precio")
	private Double precio;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "foto")
	private String foto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstadoInmueble")
	private EstadoInmueble estadoInmueble;

	public int getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(int idInmueble) {
		this.idInmueble = idInmueble;
	}

	public TipoInmueble getTipoInmueble() {
		return tipoInmueble;
	}

	public void setTipoInmueble(TipoInmueble tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public EstadoInmueble getEstadoInmueble() {
		return estadoInmueble;
	}

	public void setEstadoInmueble(EstadoInmueble estadoInmueble) {
		this.estadoInmueble = estadoInmueble;
	}
	
}
