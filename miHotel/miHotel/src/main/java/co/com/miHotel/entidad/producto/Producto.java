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
@Table(name = "producto")
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProducto", nullable = false)
	private int idProducto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSubcategoria")
	private SubCategoriaProducto subcategoria;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "precioUnitario")
	private Double precioUnitario;

	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "foto")
	private String foto;

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public SubCategoriaProducto getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(SubCategoriaProducto subcategoria) {
		this.subcategoria = subcategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
