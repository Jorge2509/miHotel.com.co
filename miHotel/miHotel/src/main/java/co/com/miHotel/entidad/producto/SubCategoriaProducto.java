package co.com.miHotel.entidad.producto;

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
@Table(name = "subCategoriaProducto")
public class SubCategoriaProducto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idSubcategoriaProducto", nullable = false)
	private int idSubcategoriaProducto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCategoriaProducto")
	private CategoriaProducto categoriaProducto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMarcaProducto")
	private MarcaProducto marcaProducto;
	
	@Column(name = "descripcion", length = 50)
	private String descripcion;

	public int getIdSubcategoria() {
		return idSubcategoriaProducto;
	}

	public void setIdSubcategoria(int idSubcategoriaProducto) {
		this.idSubcategoriaProducto = idSubcategoriaProducto;
	}

	public CategoriaProducto getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public MarcaProducto getMarcaProducto() {
		return marcaProducto;
	}

	public void setMarcaProducto(MarcaProducto marcaProducto) {
		this.marcaProducto = marcaProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
