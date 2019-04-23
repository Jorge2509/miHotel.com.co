package co.com.miHotel.entidad.inmueble;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CategoriaInmueble {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCategoriaInmueble", nullable = false)
	private int idCategoriaInmueble;

	@Column(name = "descripcion", length = 50)
	private String descripcion;

	public int getIdCategoriaInmueble() {
		return idCategoriaInmueble;
	}

	public void setIdCategoriaInmueble(int idCategoriaInmueble) {
		this.idCategoriaInmueble = idCategoriaInmueble;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
