package co.com.miHotel.modelo.login;
// Generated 05-may-2019 1:08:57 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import co.com.miHotel.modelo.persona.Persona;

/**
 * Login generated by hbm2java
 */
@Entity
@Table(name = "login", schema = "public")
public class Login implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2520806269841599029L;
	
	private int idLogin;
	private Persona persona;
	private String usuario;
	private String contrasena;
	private int idPersona;

	public Login() {
	}

	public Login(Persona persona, String usuario, String contrasena, int idPersona) {
		this.persona = persona;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.idPersona = idPersona;
	}

	@GenericGenerator(name = "modelo.LoginIdGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "persona"))
	@Id
	@GeneratedValue(generator = "modelo.LoginIdGenerator")

	@Column(name = "id_login", unique = true, nullable = false)
	public int getIdLogin() {
		return this.idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Column(name = "usuario", nullable = false)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "contrasena", nullable = false)
	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Column(name = "id_persona", nullable = false)
	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

}
