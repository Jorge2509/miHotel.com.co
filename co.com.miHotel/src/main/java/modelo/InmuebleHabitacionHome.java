package modelo;
// Generated 02-may-2019 20:47:03 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class InmuebleHabitacion.
 * @see modelo.InmuebleHabitacion
 * @author Hibernate Tools
 */
@Stateless
public class InmuebleHabitacionHome {

	private static final Log log = LogFactory.getLog(InmuebleHabitacionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(InmuebleHabitacion transientInstance) {
		log.debug("persisting InmuebleHabitacion instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(InmuebleHabitacion persistentInstance) {
		log.debug("removing InmuebleHabitacion instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public InmuebleHabitacion merge(InmuebleHabitacion detachedInstance) {
		log.debug("merging InmuebleHabitacion instance");
		try {
			InmuebleHabitacion result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public InmuebleHabitacion findById(int id) {
		log.debug("getting InmuebleHabitacion instance with id: " + id);
		try {
			InmuebleHabitacion instance = entityManager.find(InmuebleHabitacion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
