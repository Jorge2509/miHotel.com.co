package co.com.miHotel.dao.inmueble;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.inmueble.MarcaInmueble;

/**
 * Home object for domain model class MarcaInmueble.
 * @see modelo.MarcaInmueble
 * @author Hibernate Tools
 */
@Stateless
public class MarcaInmuebleHome {

	private static final Log log = LogFactory.getLog(MarcaInmuebleHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MarcaInmueble transientInstance) {
		log.debug("persisting MarcaInmueble instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MarcaInmueble persistentInstance) {
		log.debug("removing MarcaInmueble instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MarcaInmueble merge(MarcaInmueble detachedInstance) {
		log.debug("merging MarcaInmueble instance");
		try {
			MarcaInmueble result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MarcaInmueble findById(int id) {
		log.debug("getting MarcaInmueble instance with id: " + id);
		try {
			MarcaInmueble instance = entityManager.find(MarcaInmueble.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
