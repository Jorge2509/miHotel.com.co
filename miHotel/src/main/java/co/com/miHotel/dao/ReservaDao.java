package co.com.miHotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import co.com.miHotel.config.JPAUtil;
import co.com.miHotel.modelo.Persona;

public class ReservaDao {

	EntityManager em = JPAUtil.conectar().createEntityManager();
	private EntityTransaction transactionObj = em.getTransaction();
	private Persona persona;

	public Persona mostrarPersonas(String numeroDocumento) {

		// List<Persona> personaList = new ArrayList<>();

		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}

		Query query = em.createQuery("SELECT p FROM Persona p  WHERE p.numeroDocumento =:numeroDoc");
		query.setParameter("numeroDoc", numeroDocumento);
		persona = (Persona) query.getSingleResult();

		return persona;
	}

	public List<String> documentos() {
		List<String> results = new ArrayList<String>();

		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}

		Query queryObj = em.createQuery("SELECT p.numeroDocumento FROM Persona p ");
		results = queryObj.getResultList();

		return results;
	}

}
