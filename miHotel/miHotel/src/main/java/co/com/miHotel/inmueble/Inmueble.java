package co.com.miHotel.inmueble;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.com.miHotel.entidad.estado.EstadoInmueble;

@Entity
@Table(name="inmueble")
public class Inmueble {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idInmueble", nullable = false)
	private int idInmueble;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoInmueble")
	private TipoInmueble tipoInmueble;

	@Column(name = "codigo")
	private int codigo;
	
	@Column(name = "fechaIngreso")
	private Date fechaIngreso;

	@Column(name = "precio")
	private Double precio;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "foto")
	private String foto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstadoInmueble")
	private EstadoInmueble estadoInmueble;
}
