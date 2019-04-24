package co.com.miHotel.entidad.estado;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estadoHabitacion")
public class EstadoHabitacion implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idEstadoHabitacion", nullable=false)
	private int idEstadoHabitacion;
	
	@Column(name="descripcion", length = 50)
	private String descripcion;

	public int getIdEstadoHabitacion() {
		return idEstadoHabitacion;
	}

	public void setIdEstadoHabitacion(int idEstadoHabitacion) {
		this.idEstadoHabitacion = idEstadoHabitacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
