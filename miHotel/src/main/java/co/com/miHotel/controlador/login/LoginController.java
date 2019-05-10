package co.com.miHotel.controlador.login;

import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;



import co.com.miHotel.dao.login.LoginHome;
import co.com.miHotel.modelo.login.Login;

@Named (value = "loginController")
@RequestScoped

public class LoginController {

	private Login login;
	private LoginHome loginHome;

	
	
	public LoginController() {
		super();
		this.login = new Login();
		this.loginHome = new LoginHome();
	}

	public void ingresar() {
		try {
			login = loginHome.buscarLogin(login.getUsuario(), login.getContrasena());

			if (login == null) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "User not found!", " Login Error!"));
			} else {
				System.out.println("Entre");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}