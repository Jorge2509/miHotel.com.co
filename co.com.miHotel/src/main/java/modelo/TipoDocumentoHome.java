package modelo;
// Generated 02-may-2019 20:47:03 by Hibernate Tools 4.3.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TipoDocumento.
 * @see modelo.TipoDocumento
 * @author Hibernate Tools
 */
@Stateless
public class TipoDocumentoHome {

	private static final Log log = LogFactory.getLog(TipoDocumentoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TipoDocumento transientInstance) {
		log.debug("persisting TipoDocumento instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TipoDocumento persistentInstance) {
		log.debug("removing TipoDocumento instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TipoDocumento merge(TipoDocumento detachedInstance) {
		log.debug("merging TipoDocumento instance");
		try {
			TipoDocumento result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoDocumento findById(int id) {
		log.debug("getting TipoDocumento instance with id: " + id);
		try {
			TipoDocumento instance = entityManager.find(TipoDocumento.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
