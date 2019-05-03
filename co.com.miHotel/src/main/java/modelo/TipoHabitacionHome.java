package modelo;
// Generated 02-may-2019 20:47:03 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TipoHabitacion.
 * @see modelo.TipoHabitacion
 * @author Hibernate Tools
 */
@Stateless
public class TipoHabitacionHome {

	private static final Log log = LogFactory.getLog(TipoHabitacionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TipoHabitacion transientInstance) {
		log.debug("persisting TipoHabitacion instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TipoHabitacion persistentInstance) {
		log.debug("removing TipoHabitacion instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TipoHabitacion merge(TipoHabitacion detachedInstance) {
		log.debug("merging TipoHabitacion instance");
		try {
			TipoHabitacion result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoHabitacion findById(int id) {
		log.debug("getting TipoHabitacion instance with id: " + id);
		try {
			TipoHabitacion instance = entityManager.find(TipoHabitacion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
