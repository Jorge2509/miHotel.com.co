package co.com.miHotel.dao.tienda;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.tienda.Tienda;

/**
 * Home object for domain model class Tienda.
 * @see modelo.Tienda
 * @author Hibernate Tools
 */
@Stateless
public class TiendaHome {

	private static final Log log = LogFactory.getLog(TiendaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Tienda transientInstance) {
		log.debug("persisting Tienda instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Tienda persistentInstance) {
		log.debug("removing Tienda instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Tienda merge(Tienda detachedInstance) {
		log.debug("merging Tienda instance");
		try {
			Tienda result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tienda findById(int id) {
		log.debug("getting Tienda instance with id: " + id);
		try {
			Tienda instance = entityManager.find(Tienda.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
