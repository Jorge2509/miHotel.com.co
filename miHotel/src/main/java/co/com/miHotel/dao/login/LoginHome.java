package co.com.miHotel.dao.login;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.login.Login;

/**
 * Home object for domain model class Login.
 * 
 * @see modelo.Login
 * @author Hibernate Tools
 */
@Stateless
public class LoginHome {

	private static final Log log = LogFactory.getLog(LoginHome.class);

	@PersistenceContext
	//private EntityManager entityManager;
	

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("users");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	

	public void persist(Login transientInstance) {
		log.debug("persisting Login instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Login persistentInstance) {
		log.debug("removing Login instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Login merge(Login detachedInstance) {
		log.debug("merging Login instance");
		try {
			Login result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Login findById(int id) {
		log.debug("getting Login instance with id: " + id);
		try {
			Login instance = entityManager.find(Login.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Login buscarLogin(String usuario, String contrasena) {
		try {
			entityManager.getTransaction().begin();
			StringBuilder hql = new StringBuilder();

			hql.append("SELECT l from Login l ");
			hql.append(" where l.usuario = :usuario ");
			hql.append(" AND l.contrasena = :contrasena");

			Login login = (Login) entityManager.createQuery(hql.toString()).setParameter("usuario", usuario)
					.setParameter("contrasena", contrasena).getSingleResult();
			
			
		    
		    entityManager.close();
		    entityManagerFactory.close();
			
			
			return login;
		} catch (NoResultException e) {
			System.out.println("Error : " + e.getMessage());
			return new Login();
		}
	}
}
