package co.com.miHotel.dao.incidente;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.habitacion.IncidenteHabitacion;

/**
 * Home object for domain model class IncidenteHabitacion.
 * @see modelo.IncidenteHabitacion
 * @author Hibernate Tools
 */
@Stateless
public class IncidenteHabitacionHome {

	private static final Log log = LogFactory.getLog(IncidenteHabitacionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(IncidenteHabitacion transientInstance) {
		log.debug("persisting IncidenteHabitacion instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(IncidenteHabitacion persistentInstance) {
		log.debug("removing IncidenteHabitacion instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public IncidenteHabitacion merge(IncidenteHabitacion detachedInstance) {
		log.debug("merging IncidenteHabitacion instance");
		try {
			IncidenteHabitacion result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public IncidenteHabitacion findById(int id) {
		log.debug("getting IncidenteHabitacion instance with id: " + id);
		try {
			IncidenteHabitacion instance = entityManager.find(IncidenteHabitacion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
