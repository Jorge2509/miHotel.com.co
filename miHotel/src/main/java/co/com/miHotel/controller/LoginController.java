package co.com.miHotel.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import co.com.miHotel.dao.LoginDao;
import co.com.miHotel.modelo.Login;

@ManagedBean(name = "loginController")
@ViewScoped
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Login login;
	private LoginDao loginDao = new LoginDao();

	@PostConstruct
	public void init() {
		login = new Login();

	}

	public String iniciarSesion() {
		String redireccion = null;
		Login lo;
		try {

			lo = loginDao.iniciarSesion(login);
			if (lo != null) {
				redireccion = "reserva.xhtml?faces-redirect=true";
			}
			else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", " credenciales incorrectas"));
			}

		} catch (Exception e) {
			throw e;
		}

		finally {

		}

		return redireccion;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}
