package modelo;
// Generated 02-may-2019 20:47:03 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TipoInmueble.
 * @see modelo.TipoInmueble
 * @author Hibernate Tools
 */
@Stateless
public class TipoInmuebleHome {

	private static final Log log = LogFactory.getLog(TipoInmuebleHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TipoInmueble transientInstance) {
		log.debug("persisting TipoInmueble instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TipoInmueble persistentInstance) {
		log.debug("removing TipoInmueble instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TipoInmueble merge(TipoInmueble detachedInstance) {
		log.debug("merging TipoInmueble instance");
		try {
			TipoInmueble result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoInmueble findById(int id) {
		log.debug("getting TipoInmueble instance with id: " + id);
		try {
			TipoInmueble instance = entityManager.find(TipoInmueble.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
