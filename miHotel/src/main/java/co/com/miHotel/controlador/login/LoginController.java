package co.com.miHotel.controlador.login;

import antlr.StringUtils;
import co.com.miHotel.dao.login.LoginHome;
import co.com.miHotel.modelo.login.Login;

public class LoginController {

	private Login login;

	public LoginController() {
		super();
		this.login = new Login();
	}
	
	//Validaciones
	public void validarInicio() {
		if (login.getUsuario() != null) {
			System.out.println("Digite el usuario");
		}
		if (login.getContrasena() != null && login.getContrasena().equals(" ")) {
			System.out.println("Digite la contraseña");
		}
		
	}
}
