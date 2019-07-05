package co.com.miHotel.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the categoria_producto database table.
 * 
 */
@Entity
@Table(name="categoria_producto")
@NamedQuery(name="CategoriaProducto.findAll", query="SELECT c FROM CategoriaProducto c")
public class CategoriaProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categoria_producto")
	private Integer idCategoriaProducto;

	@Column(name="descripcion")
	private String descripcion;

	public CategoriaProducto() {
	}

	public Integer getIdCategoriaProducto() {
		return this.idCategoriaProducto;
	}

	public void setIdCategoriaProducto(Integer idCategoriaProducto) {
		this.idCategoriaProducto = idCategoriaProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "CategoriaProducto [idCategoriaProducto=" + idCategoriaProducto + ", descripcion=" + descripcion + "]";
	}

}