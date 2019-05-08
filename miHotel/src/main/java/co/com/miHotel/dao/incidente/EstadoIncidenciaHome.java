package co.com.miHotel.dao.incidente;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.incidente.EstadoIncidencia;

/**
 * Home object for domain model class EstadoIncidencia.
 * @see modelo.EstadoIncidencia
 * @author Hibernate Tools
 */
@Stateless
public class EstadoIncidenciaHome {

	private static final Log log = LogFactory.getLog(EstadoIncidenciaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EstadoIncidencia transientInstance) {
		log.debug("persisting EstadoIncidencia instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(EstadoIncidencia persistentInstance) {
		log.debug("removing EstadoIncidencia instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public EstadoIncidencia merge(EstadoIncidencia detachedInstance) {
		log.debug("merging EstadoIncidencia instance");
		try {
			EstadoIncidencia result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EstadoIncidencia findById(int id) {
		log.debug("getting EstadoIncidencia instance with id: " + id);
		try {
			EstadoIncidencia instance = entityManager.find(EstadoIncidencia.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
