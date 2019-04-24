package co.com.miHotel.entidad.producto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marcaProducto")
public class MarcaProducto implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMarca", nullable = false)
	private int idMarcaProducto;

	@Column(name = "descripcion", length = 150)
	private String descripcion;

	public int getIdMarcaProducto() {
		return idMarcaProducto;
	}

	public void setIdMarcaInmueble(int idMarcaProducto) {
		this.idMarcaProducto = idMarcaProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
