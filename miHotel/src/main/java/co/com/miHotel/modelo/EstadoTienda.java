package co.com.miHotel.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_tienda database table.
 * 
 */
@Entity
@Table(name="estado_tienda")
@NamedQuery(name="EstadoTienda.findAll", query="SELECT e FROM EstadoTienda e")
public class EstadoTienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_tienda")
	private Integer idEstadoTienda;

	@Column(name="descripcion")
	private String descripcion;


	public EstadoTienda() {
	}

	public Integer getIdEstadoTienda() {
		return this.idEstadoTienda;
	}

	public void setIdEstadoTienda(Integer idEstadoTienda) {
		this.idEstadoTienda = idEstadoTienda;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "EstadoTienda [idEstadoTienda=" + idEstadoTienda + ", descripcion=" + descripcion + "]";
	}

}