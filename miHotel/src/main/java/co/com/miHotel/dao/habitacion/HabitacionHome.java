package co.com.miHotel.dao.habitacion;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.habitacion.Habitacion;

/**
 * Home object for domain model class Habitacion.
 * @see modelo.Habitacion
 * @author Hibernate Tools
 */
@Stateless
public class HabitacionHome {

	private static final Log log = LogFactory.getLog(HabitacionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Habitacion transientInstance) {
		log.debug("persisting Habitacion instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Habitacion persistentInstance) {
		log.debug("removing Habitacion instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Habitacion merge(Habitacion detachedInstance) {
		log.debug("merging Habitacion instance");
		try {
			Habitacion result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Habitacion findById(int id) {
		log.debug("getting Habitacion instance with id: " + id);
		try {
			Habitacion instance = entityManager.find(Habitacion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
