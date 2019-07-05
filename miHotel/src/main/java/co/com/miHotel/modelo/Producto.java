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


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private Integer idProducto;

	@Column(name="cantidad")
	private Integer cantidad;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="foto")
	private String foto;

	@Column(name="precio_unitario")
	private double precioUnitario;

	//bi-directional many-to-one association to SubcategoriaProducto
	@ManyToOne
	@JoinColumn(name="id_subcategoria_producto")
	private SubcategoriaProducto subcategoriaProducto;

	public Producto() {
	}

	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
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

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public double getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public SubcategoriaProducto getSubcategoriaProducto() {
		return this.subcategoriaProducto;
	}

	public void setSubcategoriaProducto(SubcategoriaProducto subcategoriaProducto) {
		this.subcategoriaProducto = subcategoriaProducto;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", cantidad=" + cantidad + ", descripcion=" + descripcion
				+ ", foto=" + foto + ", precioUnitario=" + precioUnitario + ", subcategoriaProducto="
				+ subcategoriaProducto + "]";
	}

}