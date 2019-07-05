package co.com.miHotel.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the subcategoria_producto database table.
 * 
 */
@Entity
@Table(name = "subcategoria_producto")
@NamedQuery(name = "SubcategoriaProducto.findAll", query = "SELECT s FROM SubcategoriaProducto s")
public class SubcategoriaProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_subcategoria_producto")
	private Integer idSubcategoriaProducto;

	@Column(name = "descripcion")
	private String descripcion;

	// bi-directional many-to-one association to CategoriaProducto
	@ManyToOne
	@JoinColumn(name = "id_categoria_producto")
	private CategoriaProducto categoriaProducto;

	// bi-directional many-to-one association to MarcaProducto
	@ManyToOne
	@JoinColumn(name = "id_marca_producto")
	private MarcaProducto marcaProducto;

	public SubcategoriaProducto() {
	}

	public Integer getIdSubcategoriaProducto() {
		return this.idSubcategoriaProducto;
	}

	public void setIdSubcategoriaProducto(Integer idSubcategoriaProducto) {
		this.idSubcategoriaProducto = idSubcategoriaProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public CategoriaProducto getCategoriaProducto() {
		return this.categoriaProducto;
	}

	public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public MarcaProducto getMarcaProducto() {
		return this.marcaProducto;
	}

	public void setMarcaProducto(MarcaProducto marcaProducto) {
		this.marcaProducto = marcaProducto;
	}

	@Override
	public String toString() {
		return "SubcategoriaProducto [idSubcategoriaProducto=" + idSubcategoriaProducto + ", descripcion=" + descripcion
				+ ", categoriaProducto=" + categoriaProducto + ", marcaProducto=" + marcaProducto + "]";
	}

}