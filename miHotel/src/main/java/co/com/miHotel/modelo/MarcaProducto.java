package co.com.miHotel.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the marca_producto database table.
 * 
 */
@Entity
@Table(name = "marca_producto")
@NamedQuery(name = "MarcaProducto.findAll", query = "SELECT m FROM MarcaProducto m")
public class MarcaProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_marca_producto")
	private Integer idMarcaProducto;

	@Column(name = "descripcion")
	private String descripcion;

	public MarcaProducto() {
	}

	public Integer getIdMarcaProducto() {
		return this.idMarcaProducto;
	}

	public void setIdMarcaProducto(Integer idMarcaProducto) {
		this.idMarcaProducto = idMarcaProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "MarcaProducto [idMarcaProducto=" + idMarcaProducto + ", descripcion=" + descripcion + "]";
	}
}