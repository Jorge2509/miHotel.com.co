package co.com.miHotel.dao.habitacion;
// Generated 05-may-2019 1:09:10 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import co.com.miHotel.modelo.habitacion.EstadoHabitacion;

/**
 * Home object for domain model class EstadoHabitacion.
 * @see modelo.EstadoHabitacion
 * @author Hibernate Tools
 */
@Stateless
public class EstadoHabitacionDAO {

	private static final Log log = LogFactory.getLog(EstadoHabitacionDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EstadoHabitacion transientInstance) {
		log.debug("persisting EstadoHabitacion instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(EstadoHabitacion persistentInstance) {
		log.debug("removing EstadoHabitacion instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public EstadoHabitacion merge(EstadoHabitacion detachedInstance) {
		log.debug("merging EstadoHabitacion instance");
		try {
			EstadoHabitacion result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EstadoHabitacion findById(int id) {
		log.debug("getting EstadoHabitacion instance with id: " + id);
		try {
			EstadoHabitacion instance = entityManager.find(EstadoHabitacion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
