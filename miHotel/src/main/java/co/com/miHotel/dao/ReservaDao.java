package co.com.miHotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import co.com.miHotel.config.JPAUtil;
import co.com.miHotel.modelo.Habitacion;
import co.com.miHotel.modelo.Persona;

public class ReservaDao {

	EntityManager em = JPAUtil.conectar().createEntityManager();
	private EntityTransaction transactionObj = em.getTransaction();
	private Persona persona;

	public Persona mostrarPersonas(String numeroDocumento) {

		// List<Persona> personaList = new ArrayList<>();
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}

			Query query = em.createQuery("SELECT p FROM Persona p  WHERE p.numeroDocumento =:numeroDoc");
			query.setParameter("numeroDoc", numeroDocumento);

			persona = (Persona) query.getSingleResult();
		}

		catch (Exception e) {
			persona = null;
		}

		return persona;
	}

//	public List<String> numHabitacion() {
//		List<String> results = new ArrayList<String>();
//
//		if (!em.getTransaction().isActive()) {
//			em.getTransaction().begin();
//		}
//
//		Query queryObj = em.createQuery("SELECT h.numeroHabitacion FROM Habitacion h  WHERE h. .idEstadoHabitacion=1");
//		results = queryObj.getResultList();
//
//		return results;
//	}
	
	
	
public List <Habitacion> listaHabitaciones( Integer tipo){
	List<Habitacion> results = new ArrayList<>();
	if (!em.getTransaction().isActive()) {
	em.getTransaction().begin(); }
	
	Query queryObj = em.createQuery("SELECT h FROM Habitacion h  WHERE h.estadoHabitacion.idEstadoHabitacion=1 AND h.tipoHabitacion.idTipoHabitacion=:idTipo");
	queryObj.setParameter("idTipo", tipo);
	results = queryObj.getResultList();
	
	return results;
	
}
	
}



