package modelo;
// Generated 02-may-2019 20:47:03 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Login.
 * @see modelo.Login
 * @author Hibernate Tools
 */
@Stateless
public class LoginHome {

	private static final Log log = LogFactory.getLog(LoginHome.class);

	@PersistenceContext
	private EntityManager entityManager;

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
}
