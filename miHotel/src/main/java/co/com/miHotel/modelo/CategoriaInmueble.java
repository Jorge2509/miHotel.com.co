package co.com.miHotel.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the categoria_inmueble database table.
 * 
 */
@Entity
@Table(name = "categoria_inmueble")
@NamedQuery(name = "CategoriaInmueble.findAll", query = "SELECT c FROM CategoriaInmueble c")
public class CategoriaInmueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "idcategoria_inmueble")
	private Integer idcategoriaInmueble;
	
	@Column(name = "descripcion")
	private String descripcion;

	public CategoriaInmueble() {
	}

	public Integer getIdcategoriaInmueble() {
		return this.idcategoriaInmueble;
	}

	public void setIdcategoriaInmueble(Integer idcategoriaInmueble) {
		this.idcategoriaInmueble = idcategoriaInmueble;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}