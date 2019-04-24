package co.com.miHotel.entidad.producto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoriaProducto")
public class CategoriaProducto implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCategoriaProducto", nullable = false)
	private int idCategoriaProducto;

	@Column(name = "descripcion", length = 150)
	private String descripcion;

	public int getIdCategoriaProducto() {
		return idCategoriaProducto;
	}

	public void setIdCategoriaProducto(int idCategoriaProducto) {
		this.idCategoriaProducto = idCategoriaProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
