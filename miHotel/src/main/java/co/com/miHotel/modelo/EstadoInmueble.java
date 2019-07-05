package co.com.miHotel.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_inmueble database table.
 * 
 */
@Entity
@Table(name="estado_inmueble")
@NamedQuery(name="EstadoInmueble.findAll", query="SELECT e FROM EstadoInmueble e")
public class EstadoInmueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_inmueble")
	private Integer idEstadoInmueble;

	@Column(name="descripcion")
	private String descripcion;

	public EstadoInmueble() {
	}

	public Integer getIdEstadoInmueble() {
		return this.idEstadoInmueble;
	}

	public void setIdEstadoInmueble(Integer idEstadoInmueble) {
		this.idEstadoInmueble = idEstadoInmueble;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "EstadoInmueble [idEstadoInmueble=" + idEstadoInmueble + ", descripcion=" + descripcion + "]";
	}

}