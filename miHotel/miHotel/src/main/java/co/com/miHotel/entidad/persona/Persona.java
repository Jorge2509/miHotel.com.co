package co.com.miHotel.entidad.persona;

import java.io.Serializable;
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

import co.com.miHotel.entidad.estado.EstadoPersona;
import co.com.miHotel.entidad.rol.Rol;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPersona", nullable = false)
	private int idPersona;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoDocumento")
	private TipoDocumento tipoDocumento;
	
	@Column(name = "numeroDocumento")
	private String numeroDocumento;
	
	@Column(name = "primerNombre")
	private String primerNombre;
	
	@Column(name = "segundoNombre")
	private String segundoNombre;
	
	@Column(name = "primerApellido")
	private String primerApellido;
	
	@Column(name = "segundoApellido")
	private String segundoApellido;
	
	@Column(name = "telefono")
	private int telefono;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "fechaNacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "edad")
	private int edad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRol")
	private Rol rol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstadoPersona")
	private EstadoPersona estadoPersona;

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public EstadoPersona getEstadoPersona() {
		return estadoPersona;
	}

	public void setEstadoPersona(EstadoPersona estadoPersona) {
		this.estadoPersona = estadoPersona;
	}
}
