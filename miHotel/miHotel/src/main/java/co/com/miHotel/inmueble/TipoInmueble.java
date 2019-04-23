package co.com.miHotel.inmueble;

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

@Entity
@Table(name = "tipoInmueble")
public class TipoInmueble implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTipoInmueble", nullable = false)
	private int idTipoInmueble;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idInmueble")
	private Inmueble inmueble;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMarca")
	private MarcaInmueble marcaInmueble;
	
	@Column(name = "descripcion", length = 50)
	private String descripcion;
	
	@Column(name = "cantidad")
	private int cantidad;

	public int getIdTipoInmueble() {
		return idTipoInmueble;
	}

	public void setIdTipoInmueble(int idTipoInmueble) {
		this.idTipoInmueble = idTipoInmueble;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public MarcaInmueble getMarcaInmueble() {
		return marcaInmueble;
	}

	public void setMarcaInmueble(MarcaInmueble marcaInmueble) {
		this.marcaInmueble = marcaInmueble;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
