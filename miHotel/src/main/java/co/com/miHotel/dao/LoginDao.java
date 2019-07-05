package co.com.miHotel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;

import co.com.miHotel.config.JPAUtil;
import co.com.miHotel.modelo.Login;

public class LoginDao {

	EntityManager em = JPAUtil.conectar().createEntityManager();



	public Login iniciarSesion(Login log) {

		Login login = null;
		String consulta;
		try {
			if (!em.getTransaction().isActive()) {

				em.getTransaction().begin();
			}

			consulta = "FROM Login l WHERE l.usuario =:user and l.contrasena =:pass";
			Query query = em.createQuery(consulta);
			query.setParameter("user", log.getUsuario());
			query.setParameter("pass", log.getContrasena());
			query.getResultList();
			List<Login> listLogin = query.getResultList();

			if (!listLogin.isEmpty()) {
				login = listLogin.get(0);
			}
		}

		catch (Exception e) {
			throw e;

		}
		// finally {
		// em.close();
		//
		// }

		return login;

	}

}
