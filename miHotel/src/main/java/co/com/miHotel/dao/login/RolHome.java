package co.com.miHotel.dao.login;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.login.Rol;

/**
 * Home object for domain model class Rol.
 * @see modelo.Rol
 * @author Hibernate Tools
 */
@Stateless
public class RolHome {

	private static final Log log = LogFactory.getLog(RolHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Rol transientInstance) {
		log.debug("persisting Rol instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Rol persistentInstance) {
		log.debug("removing Rol instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Rol merge(Rol detachedInstance) {
		log.debug("merging Rol instance");
		try {
			Rol result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Rol findById(int id) {
		log.debug("getting Rol instance with id: " + id);
		try {
			Rol instance = entityManager.find(Rol.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
