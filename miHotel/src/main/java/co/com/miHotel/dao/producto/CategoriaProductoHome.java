package co.com.miHotel.dao.producto;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.producto.CategoriaProducto;

/**
 * Home object for domain model class CategoriaProducto.
 * @see modelo.CategoriaProducto
 * @author Hibernate Tools
 */
@Stateless
public class CategoriaProductoHome {

	private static final Log log = LogFactory.getLog(CategoriaProductoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CategoriaProducto transientInstance) {
		log.debug("persisting CategoriaProducto instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CategoriaProducto persistentInstance) {
		log.debug("removing CategoriaProducto instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CategoriaProducto merge(CategoriaProducto detachedInstance) {
		log.debug("merging CategoriaProducto instance");
		try {
			CategoriaProducto result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CategoriaProducto findById(int id) {
		log.debug("getting CategoriaProducto instance with id: " + id);
		try {
			CategoriaProducto instance = entityManager.find(CategoriaProducto.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
