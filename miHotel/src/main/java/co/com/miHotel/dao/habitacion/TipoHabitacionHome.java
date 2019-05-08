package co.com.miHotel.dao.habitacion;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.habitacion.TipoHabitacion;

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
