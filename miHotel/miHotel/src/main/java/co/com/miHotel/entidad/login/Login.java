package co.com.miHotel.entidad.login;

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

import co.com.miHotel.entidad.persona.Persona;

@Entity
@Table(name = "login")
public class Login implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idLogin", nullable=false)
	private int idLogin;

	@Column(name = "usuario")
	private String usuario;

	@Column(name = "contrasena")
	private String contrasena;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersona")
	private Persona persona;

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
