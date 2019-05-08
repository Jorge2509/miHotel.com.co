package co.com.miHotel.dao.persona;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.persona.EstadoPersona;

/**
 * Home object for domain model class EstadoPersona.
 * @see modelo.EstadoPersona
 * @author Hibernate Tools
 */
@Stateless
public class EstadoPersonaHome {

	private static final Log log = LogFactory.getLog(EstadoPersonaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EstadoPersona transientInstance) {
		log.debug("persisting EstadoPersona instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(EstadoPersona persistentInstance) {
		log.debug("removing EstadoPersona instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public EstadoPersona merge(EstadoPersona detachedInstance) {
		log.debug("merging EstadoPersona instance");
		try {
			EstadoPersona result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EstadoPersona findById(int id) {
		log.debug("getting EstadoPersona instance with id: " + id);
		try {
			EstadoPersona instance = entityManager.find(EstadoPersona.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
