package modelo;
// Generated 02-may-2019 20:47:03 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
