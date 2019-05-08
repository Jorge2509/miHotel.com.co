package co.com.miHotel.dao.incidente;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.inmueble.IncidenteInmueble;

/**
 * Home object for domain model class IncidenteInmueble.
 * @see modelo.IncidenteInmueble
 * @author Hibernate Tools
 */
@Stateless
public class IncidenteInmuebleHome {

	private static final Log log = LogFactory.getLog(IncidenteInmuebleHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(IncidenteInmueble transientInstance) {
		log.debug("persisting IncidenteInmueble instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(IncidenteInmueble persistentInstance) {
		log.debug("removing IncidenteInmueble instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public IncidenteInmueble merge(IncidenteInmueble detachedInstance) {
		log.debug("merging IncidenteInmueble instance");
		try {
			IncidenteInmueble result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public IncidenteInmueble findById(int id) {
		log.debug("getting IncidenteInmueble instance with id: " + id);
		try {
			IncidenteInmueble instance = entityManager.find(IncidenteInmueble.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
