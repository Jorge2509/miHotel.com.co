package co.com.miHotel.dao.inmueble;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.inmueble.TipoInmueble;

/**
 * Home object for domain model class TipoInmueble.
 * @see modelo.TipoInmuebleO
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
