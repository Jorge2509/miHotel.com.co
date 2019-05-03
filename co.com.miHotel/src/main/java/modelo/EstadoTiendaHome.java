package modelo;
// Generated 02-may-2019 20:47:03 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class EstadoTienda.
 * @see modelo.EstadoTienda
 * @author Hibernate Tools
 */
@Stateless
public class EstadoTiendaHome {

	private static final Log log = LogFactory.getLog(EstadoTiendaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EstadoTienda transientInstance) {
		log.debug("persisting EstadoTienda instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(EstadoTienda persistentInstance) {
		log.debug("removing EstadoTienda instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public EstadoTienda merge(EstadoTienda detachedInstance) {
		log.debug("merging EstadoTienda instance");
		try {
			EstadoTienda result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EstadoTienda findById(int id) {
		log.debug("getting EstadoTienda instance with id: " + id);
		try {
			EstadoTienda instance = entityManager.find(EstadoTienda.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
