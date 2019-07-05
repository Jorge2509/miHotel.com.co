package co.com.miHotel.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tienda database table.
 * 
 */
@Entity
@NamedQuery(name="Tienda.findAll", query="SELECT t FROM Tienda t")
public class Tienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compra")
	private Integer idCompra;

	@Column(name="cantidad")
	private Integer cantidad;

	@Column(name="precio_total")
	private double precioTotal;

	//bi-directional many-to-one association to EstadoTienda
	@ManyToOne
	@JoinColumn(name="id_estado_tienda")
	private EstadoTienda estadoTienda;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="id_reserva")
	private Reserva reserva;

	public Tienda() {
	}

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public EstadoTienda getEstadoTienda() {
		return estadoTienda;
	}

	public void setEstadoTienda(EstadoTienda estadoTienda) {
		this.estadoTienda = estadoTienda;
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

	@Override
	public String toString() {
		return "Tienda [idCompra=" + idCompra + ", cantidad=" + cantidad + ", precioTotal=" + precioTotal
				+ ", estadoTienda=" + estadoTienda + ", producto=" + producto + ", reserva=" + reserva + "]";
	}
}