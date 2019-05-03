package modelo;
// Generated 02-may-2019 20:47:03 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class CategoriaInmueble.
 * @see modelo.CategoriaInmueble
 * @author Hibernate Tools
 */
@Stateless
public class CategoriaInmuebleHome {

	private static final Log log = LogFactory.getLog(CategoriaInmuebleHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CategoriaInmueble transientInstance) {
		log.debug("persisting CategoriaInmueble instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CategoriaInmueble persistentInstance) {
		log.debug("removing CategoriaInmueble instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CategoriaInmueble merge(CategoriaInmueble detachedInstance) {
		log.debug("merging CategoriaInmueble instance");
		try {
			CategoriaInmueble result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CategoriaInmueble findById(int id) {
		log.debug("getting CategoriaInmueble instance with id: " + id);
		try {
			CategoriaInmueble instance = entityManager.find(CategoriaInmueble.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
