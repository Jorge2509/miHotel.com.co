package co.com.miHotel.entidad.estado;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estadoTienda")
public class EstadoTienda implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idEstadoTienda", nullable=false)
	private int idEstadoTienda;
	
	@Column(name="descripcion", length = 50)
	private String descripcion;

	public int getIdEstadoTienda() {
		return idEstadoTienda;
	}

	public void setIdEstadoTienda(int idEstadoTienda) {
		this.idEstadoTienda = idEstadoTienda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
