package co.com.miHotel.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the estado_persona database table.
 * 
 */
@Entity
@Table(name="estado_persona")
@NamedQuery(name="EstadoPersona.findAll", query="SELECT e FROM EstadoPersona e")
public class EstadoPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_persona")
	private Integer idEstadoPersona;

	@Column(name="descripcion")
	private String descripcion;


	public EstadoPersona() {
	}

	public Integer getIdEstadoPersona() {
		return this.idEstadoPersona;
	}

	public void setIdEstadoPersona(Integer idEstadoPersona) {
		this.idEstadoPersona = idEstadoPersona;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "EstadoPersona [idEstadoPersona=" + idEstadoPersona + ", descripcion=" + descripcion + "]";
	}

}