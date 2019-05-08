package co.com.miHotel.dao.producto;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.producto.SubcategoriaProducto;

/**
 * Home object for domain model class SubcategoriaProducto.
 * @see modelo.SubcategoriaProducto
 * @author Hibernate Tools
 */
@Stateless
public class SubcategoriaProductoHome {

	private static final Log log = LogFactory.getLog(SubcategoriaProductoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(SubcategoriaProducto transientInstance) {
		log.debug("persisting SubcategoriaProducto instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(SubcategoriaProducto persistentInstance) {
		log.debug("removing SubcategoriaProducto instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public SubcategoriaProducto merge(SubcategoriaProducto detachedInstance) {
		log.debug("merging SubcategoriaProducto instance");
		try {
			SubcategoriaProducto result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SubcategoriaProducto findById(int id) {
		log.debug("getting SubcategoriaProducto instance with id: " + id);
		try {
			SubcategoriaProducto instance = entityManager.find(SubcategoriaProducto.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
