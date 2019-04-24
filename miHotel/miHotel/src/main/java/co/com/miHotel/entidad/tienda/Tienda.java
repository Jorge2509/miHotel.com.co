package co.com.miHotel.entidad.tienda;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.com.miHotel.entidad.estado.EstadoTienda;
import co.com.miHotel.entidad.producto.Producto;
import co.com.miHotel.entidad.reserva.Reserva;

@Entity
@Table(name = "tienda")
public class Tienda implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHabitacion", nullable = false)
	private int idHabitacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProducto")
	private Producto producto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idReserva")
	private Reserva reserva;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "precioTotal")
	private Double precioTotal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstadoTienda")
	private EstadoTienda estadoTienda;

	public int getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(int idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public EstadoTienda getEstadoTienda() {
		return estadoTienda;
	}

	public void setEstadoTienda(EstadoTienda estadoTienda) {
		this.estadoTienda = estadoTienda;
	}
}
