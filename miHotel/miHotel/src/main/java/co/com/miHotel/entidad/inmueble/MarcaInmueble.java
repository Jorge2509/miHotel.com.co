package co.com.miHotel.entidad.inmueble;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marcaInmueble")
public class MarcaInmueble implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMarcaInmueble", nullable = false)
	private int idMarcaInmueble;

	@Column(name = "descripcion", length = 50)
	private String descripcion;

	public int getIdMarcaInmueble() {
		return idMarcaInmueble;
	}

	public void setIdMarcaInmueble(int idMarcaInmueble) {
		this.idMarcaInmueble = idMarcaInmueble;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
