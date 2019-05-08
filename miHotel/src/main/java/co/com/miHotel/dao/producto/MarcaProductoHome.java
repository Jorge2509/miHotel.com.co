package co.com.miHotel.dao.producto;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.producto.MarcaProducto;

/**
 * Home object for domain model class MarcaProducto.
 * @see modelo.MarcaProducto
 * @author Hibernate Tools
 */
@Stateless
public class MarcaProductoHome {

	private static final Log log = LogFactory.getLog(MarcaProductoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MarcaProducto transientInstance) {
		log.debug("persisting MarcaProducto instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MarcaProducto persistentInstance) {
		log.debug("removing MarcaProducto instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MarcaProducto merge(MarcaProducto detachedInstance) {
		log.debug("merging MarcaProducto instance");
		try {
			MarcaProducto result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MarcaProducto findById(int id) {
		log.debug("getting MarcaProducto instance with id: " + id);
		try {
			MarcaProducto instance = entityManager.find(MarcaProducto.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
