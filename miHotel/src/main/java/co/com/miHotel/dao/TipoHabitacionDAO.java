package co.com.miHotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.miHotel.config.JPAUtil;
import co.com.miHotel.modelo.TipoHabitacion;

public class TipoHabitacionDAO {
	EntityManager em = JPAUtil.conectar().createEntityManager();
	

	/**
	 * @author Ximena 11/07/2019 metodo para buscar los tipos de habitacion
	 * @return TiposList: Lista de Tipos de habitaciones
	 */
	public List<TipoHabitacion> findAll() {

		List<TipoHabitacion> TiposList = new ArrayList<>();
		try {
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			Query query = em.createQuery("SELECT th FROM TipoHabitacion th");
			TiposList = query.getResultList();
		} catch (Exception e) {
			System.out.println("Error en HabitacionDAO.findAll(): " + e);
			em.getTransaction().rollback();
		}
		return TiposList;
	}
}
