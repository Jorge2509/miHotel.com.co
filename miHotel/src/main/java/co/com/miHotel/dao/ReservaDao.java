package co.com.miHotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import co.com.miHotel.config.JPAUtil;
import co.com.miHotel.modelo.Habitacion;
import co.com.miHotel.modelo.Persona;
import co.com.miHotel.modelo.Reserva;

public class ReservaDao {

	EntityManager em = JPAUtil.conectar().createEntityManager();
	private EntityTransaction transactionObj = em.getTransaction();
	private Persona persona;
	private Habitacion habitacion;

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

	public List<String> numerosHabitacion(Integer tipo) {
		List<String> results = new ArrayList<>();
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}

		Query queryObj = em.createQuery(
				"SELECT h.numeroHabitacion FROM Habitacion h WHERE h.estadoHabitacion.idEstadoHabitacion=1 AND h.tipoHabitacion.idTipoHabitacion=:idTipo");
		queryObj.setParameter("idTipo", tipo);
		results = queryObj.getResultList();

		return results;

	}

	public Habitacion autocompletarHabitacion(String numeroHabitacion) {
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			Query queryObj = em.createQuery("SELECT h FROM Habitacion h  WHERE h.numeroHabitacion =:numeroHabitacion ");
			queryObj.setParameter("numeroHabitacion", numeroHabitacion);
			habitacion = (Habitacion) queryObj.getSingleResult();
		} catch (Exception e) {
			System.out.println("Error id repetidos");
		}
		return habitacion;
	}

	public void guardarReserva(Reserva reserva) {

		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(reserva);
			em.getTransaction().commit();
			System.out.println("Creado con exito");
		} catch (Exception e) {
			System.out.println("Error en guardar Reserva: " + e);
			em.getTransaction().rollback();
		}

	}

}
