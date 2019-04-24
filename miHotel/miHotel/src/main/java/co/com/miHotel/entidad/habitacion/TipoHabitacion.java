package co.com.miHotel.entidad.habitacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tipoHabitacion")
public class TipoHabitacion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTipoHabitacion", nullable = false)
	private int idTipoHabitacion;

	@Column(name = "descripcion", length = 50)
	private String descripcion;

	public int getIdTipoHabitacion() {
		return idTipoHabitacion;
	}

	public void setIdTipoHabitacion(int idTipoHabitacion) {
		this.idTipoHabitacion = idTipoHabitacion;
	}
}
