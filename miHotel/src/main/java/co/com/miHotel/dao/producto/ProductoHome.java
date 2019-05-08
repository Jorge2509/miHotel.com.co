package co.com.miHotel.dao.producto;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.producto.Producto;

/**
 * Home object for domain model class Producto.
 * @see modelo.Producto
 * @author Hibernate Tools
 */
@Stateless
public class ProductoHome {

	private static final Log log = LogFactory.getLog(ProductoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Producto transientInstance) {
		log.debug("persisting Producto instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Producto persistentInstance) {
		log.debug("removing Producto instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Producto merge(Producto detachedInstance) {
		log.debug("merging Producto instance");
		try {
			Producto result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Producto findById(int id) {
		log.debug("getting Producto instance with id: " + id);
		try {
			Producto instance = entityManager.find(Producto.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
