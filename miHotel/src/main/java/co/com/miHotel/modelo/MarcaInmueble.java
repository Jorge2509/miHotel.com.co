package co.com.miHotel.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the marca_inmueble database table.
 * 
 */
@Entity
@Table(name = "marca_inmueble")
@NamedQuery(name = "MarcaInmueble.findAll", query = "SELECT m FROM MarcaInmueble m")
public class MarcaInmueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_marca_inmueble")
	private Integer idMarcaInmueble;

	@Column(name = "descripcion")
	private String descripcion;

	public MarcaInmueble() {
	}

	public Integer getIdMarcaInmueble() {
		return this.idMarcaInmueble;
	}

	public void setIdMarcaInmueble(Integer idMarcaInmueble) {
		this.idMarcaInmueble = idMarcaInmueble;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "MarcaInmueble [idMarcaInmueble=" + idMarcaInmueble + ", descripcion=" + descripcion + "]";
	}

}