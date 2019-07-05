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
import javax.persistence.Table;


/**
 * The persistent class for the tipo_inmueble database table.
 * 
 */
@Entity
@Table(name="tipo_inmueble")
@NamedQuery(name="TipoInmueble.findAll", query="SELECT t FROM TipoInmueble t")
public class TipoInmueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_inmueble")
	private Integer idTipoInmueble;

	@Column(name="cantidad")
	private Integer cantidad;

	@Column(name="descripcion")
	private String descripcion;

	//bi-directional many-to-one association to Inmueble
	@ManyToOne
	@JoinColumn(name="id_inmueble")
	private Inmueble inmueble;

	//bi-directional many-to-one association to MarcaInmueble
	@ManyToOne
	@JoinColumn(name="id_marca_inmueble")
	private MarcaInmueble marcaInmueble;

	public TipoInmueble() {
	}

	public Integer getIdTipoInmueble() {
		return this.idTipoInmueble;
	}

	public void setIdTipoInmueble(Integer idTipoInmueble) {
		this.idTipoInmueble = idTipoInmueble;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Inmueble getInmueble1() {
		return this.inmueble;
	}

	public MarcaInmueble getMarcaInmueble() {
		return this.marcaInmueble;
	}

	public void setMarcaInmueble(MarcaInmueble marcaInmueble) {
		this.marcaInmueble = marcaInmueble;
	}

	@Override
	public String toString() {
		return "TipoInmueble [idTipoInmueble=" + idTipoInmueble + ", cantidad=" + cantidad + ", descripcion="
				+ descripcion + ", inmueble=" + inmueble + ", marcaInmueble=" + marcaInmueble + "]";
	}
	
}