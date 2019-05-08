package co.com.miHotel.dao.inmueble;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.inmueble.EstadoInmueble;

/**
 * Home object for domain model class EstadoInmueble.
 * @see modelo.EstadoInmueble
 * @author Hibernate Tools
 */
@Stateless
public class EstadoInmuebleHome {

	private static final Log log = LogFactory.getLog(EstadoInmuebleHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EstadoInmueble transientInstance) {
		log.debug("persisting EstadoInmueble instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(EstadoInmueble persistentInstance) {
		log.debug("removing EstadoInmueble instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public EstadoInmueble merge(EstadoInmueble detachedInstance) {
		log.debug("merging EstadoInmueble instance");
		try {
			EstadoInmueble result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EstadoInmueble findById(int id) {
		log.debug("getting EstadoInmueble instance with id: " + id);
		try {
			EstadoInmueble instance = entityManager.find(EstadoInmueble.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
