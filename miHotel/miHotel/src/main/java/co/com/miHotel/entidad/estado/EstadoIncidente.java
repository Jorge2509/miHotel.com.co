package co.com.miHotel.entidad.estado;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estadoIncidente")
public class EstadoIncidente implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEstadoIncidente", nullable = false)
	private int idEstadoIncidente;

	@Column(name = "descripcion", length = 50)
	private String descripcion;

	public int getIdEstadoIncidente() {
		return idEstadoIncidente;
	}

	public void setIdEstadoIncidente(int idEstadoIncidente) {
		this.idEstadoIncidente = idEstadoIncidente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
